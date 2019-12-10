package com.avalinejad.sport.ui.home

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.alirezaafkar.sundatepicker.DatePicker


import com.avalinejad.sport.adapters.RecyclerViewAdapter
import com.avalinejad.sport.database.AppDatabase
import com.avalinejad.sport.database.dao.AteFoodDao
import com.avalinejad.sport.database.dao.DetailDao
import com.avalinejad.sport.database.dao.FoodDao
import com.avalinejad.sport.database.entity.Food
import com.avalinejad.sport.ui.addfood.AddFood
import com.avalinejad.sport.util.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import com.avalinejad.sport.R
import com.avalinejad.sport.adapters.ExerciseAdapter
import com.avalinejad.sport.model.UserAteFoods
import com.avalinejad.sport.ui.BMI.BMIActivity
import com.avalinejad.sport.ui.BaseActivity
import com.avalinejad.sport.util.Date
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.DataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.add_food_dialog.*


class HomeActivity : BaseActivity() {

    var adapter: RecyclerViewAdapter? = null
    var exerAdapter: ExerciseAdapter? = null
    var layoutManager: LinearLayoutManager? = null
    var database: AppDatabase? = null
    var ateFoodDao: AteFoodDao? = null
    var foodDao: FoodDao? = null
    var detailDao: DetailDao? = null
    var i = 0
    val chartLbls = arrayOf("میان وعده", "شام", "نهار", "صبحانه")
    var isDateChanged = false
    var userPrefs: SavedSharedPrerefrences? = null
    var userDay: Int = 0
    var userMonth: Int = 0
    var userYear: Int = 0
    var userSelectedDate = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //  this.toast("common list size is : ${commonList.size} in line 55")
        Log.d("today", " today date is : $today")
        userPrefs = SavedSharedPrerefrences(this)
        val typeface =
            Typeface.createFromAsset(applicationContext.assets, "fonts/iran_sans_normal.ttf")

        todayDate.text = dateHelper(today_Date)
        initDataBaseShits()
        //loadStoredData()
        addExtraToList()
        //this.toast("common list size is : ${commonList.size} in line 59")
        barChart.setMaxVisibleValueCount(4)
        barChart.setPinchZoom(false)
        barChart.setDrawBarShadow(false)
        barChart.setDrawGridBackground(false)
        //barChart.background = resources.getDrawable(R.drawable.add_food_confirm_background)
        barChart.axisLeft.setDrawGridLines(false)
        barChart.xAxis.setDrawGridLines(false)
        barChart.axisRight.setDrawGridLines(false)
        barChart.setScaleEnabled(false)
        val xAxis = barChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.isGranularityEnabled = true
        barChart.xAxis.valueFormatter = IndexAxisValueFormatter(chartLbls)

        barChart.axisLeft.setDrawGridLines(false)
        barChart.axisLeft.typeface = typeface
        barChart.axisLeft.setStartAtZero(true)
        barChart.axisRight.setStartAtZero(true)
        barChart.animateY(1500)
        barChart.description.isEnabled = false
        //todayDate.text = dateHelper()
        barChart.legend.isEnabled = false



        if (exerciseList.isEmpty()) {
            exerciseLBl.visibility = View.GONE
        }
        todayDate.setOnClickListener {

            val mDate = Date()
            val builder1 = DatePicker.Builder()
                .id(1)
                .date(mDate.day, mDate.getMonth(), mDate.getYear())
                .build { id, calendar, day, month, year ->
                    calendar!!.time.toString()
                    //his.toast("is it working ?"+calendar!!.time.toString())
                    //todayDate.text = calendar!!.time.toString().subSequence(4,10)
                    todayDate.text = dateHelper(day, month)
                    userDay = day
                    userMonth = month
                    userYear = year
                    userSelectedDate = returnStandardDate(day, month, year)
                    Log.d("compareDates", "user selected date in line 117 is :" + userSelectedDate)
                    mDate.setDate(day, month, year)
                    Log.d("timestamp", returnStandardDate(day, month, year))
                    userSelectedDate = returnStandardDate(userDay, userMonth, userYear)
                    isDateChanged = true
                    Log.d("dateTime", "$day and $month and $year")
                    startNewActivity()
                }
                .show(supportFragmentManager, "")

            Log.d("compareDates", "today date is :" + today_Date)
            Log.d("compareDates", "user selected date is :" + userSelectedDate)
            if (!today_Date.equals(userSelectedDate)) {
                Log.d("timestamp", "is it cleared ?")
                saveUserFoods()
                commonList.clear()
                exerciseList.clear()
            } else {
                Log.d("compareTimeStamp", "else is executed.")
                loadUserFood(userSelectedDate)
            }
        }


        adFoodButton.setOnClickListener {
            val intent = Intent(this, AddFood::class.java)
            intent.putExtra("food_button", "120")
            startActivity(intent)
        }

        add_exercise.setOnClickListener {
            val intent = Intent(this, AddFood::class.java)
            intent.putExtra("exercise_button", "121")
            startActivity(intent)
        }
        calculateCalories()

        calculateBmi.setOnClickListener {
            startActivity(Intent(this, BMIActivity::class.java))
        }
    }

    private fun startNewActivity() {
        Log.d("timestamp", "Invoked")
        saveUserFoods()
        startActivity(Intent(this, HomeActivity::class.java))
    }

    private fun getDialogFood(): Food? {
        if (intent.hasExtra(EXTRA_FOOD)) {
            Log.d(EXTRA_FOOD, "food extra has been found")
            return intent.getSerializableExtra(EXTRA_FOOD) as Food
        }
        Log.d(EXTRA_FOOD, "returned null")
        return null
    }

    private fun addExtraToList() {
        val food = getDialogFood()
        // this.toast("common list size is : ${commonList.size} in line 55")
        if (food != null) {
            commonList.add(food)
            //      this.toast("common list size is : ${commonList.size} in line 55")
            Log.d(
                "extra_food",
                "common list size now is : ${commonList.size} and received food is ${food.name}"
            )
            adapter = RecyclerViewAdapter(commonList, this)
            adapter!!.notifyItemInserted(commonList.size - 1)
            // initRecAdapter()
            //   this.toast("common list size is : ${commonList.size} in line 55")
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (tempList.size > 0) {
            //     Toast.makeText(this,"data has been saved from here",Toast.LENGTH_SHORT).show()
            saveOnExit()

        } else {
            //         Toast.makeText(this,"data has not been saved because list is empty",Toast.LENGTH_SHORT).show()
        }
        // Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show()
    }

    private fun initCommotList() {

    }

    private fun initDataBaseShits() {
        database = AppDatabase.getDatabase(this)
        ateFoodDao = database!!.ateFoodDao()
        foodDao = database!!.foodDao()
        detailDao = database!!.detailDao()
    }


    private fun saveOnExit() {
        Log.d("extra_food", "saveOnExit list size is : ${tempList.size}")
        GlobalScope.launch {
            this@HomeActivity.let {
                for (item in tempList)
                    detailDao!!.insertAll(item)
                // Log.d("extra_food","saveOnExit Saving: ${item.name}"  )
            }
        }
        tempList.clear()
    }

    private fun retreiveOnStart() {

    }

    override fun onStart() {
        super.onStart()
        //  Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show()
//        GlobalScope.launch {
//            this@HomeActivity.let {
//                val size = AppDatabase.getDatabase(this@HomeActivity).detailDao().getAll().size
//                Log.d("globalscope","still is not empty and size is $size and second element is : ")
//            }
//        }
        if (commonList.isEmpty()) {
            //  this.toast("still empty outside global scope ()")
        }
    }

    override fun onStop() {
        super.onStop()
        // this.toast("common list size is : ${commonList.size} in line 207")
    }

    override fun onRestart() {
        super.onRestart()

        //  this.toast("common list size is : ${commonList.size} in line 213")
    }

    override fun onResume() {
        super.onResume()
        //   this.toast("common list size is : ${commonList.size} in line 218")
        initRecAdapter() // dont you date touch this line
        commonList.addAll(tempList)
        tempList.clear()
        //   this.toast("common list size is : ${commonList.size}")
        adapter!!.notifyItemRangeInserted(commonList.size - 1, tempList.size)
        calculateCalories()
        calculateBurntCalories()
        //    this.toast("common list size is : ${commonList.size} in line 225")

        if (exerciseList.isEmpty()) {
            exerciseLBl.visibility = View.GONE
        }
        if (commonList.isEmpty()) {
            foodLbl.visibility = View.GONE
            // home_status_text_view.visibility = View.VISIBLE
        } else {
            foodLbl.visibility = View.VISIBLE
            //home_status_text_view.visibility = View.GONE
        }
        produceBarChartData()
    }

    private fun loadStoredData() {
        GlobalScope.launch {
            this@HomeActivity.let {
                commonList = detailDao!!.getAll()
                updateLASTITEMINDEX(commonList.size)
                if (commonList.isEmpty()) {
                    Log.d("globalscope", "list is empty")
                } else {
                    Looper.prepare()
                    //          this@HomeActivity.toast("common list size is : ${commonList.size} in line 240")
                    initRecAdapter()
                    produceBarChartData()
//                    exercise_recycler_view.adapter = RecyclerViewAdapter(commonList,it)
//                    exercise_recycler_view.layoutManager = LinearLayoutManager(it)
                }
            }
        }
    }


    private fun initRecAdapter() {
        if (!exerciseList.isEmpty()) {
            exerciseLBl.visibility = View.VISIBLE
        }
        Log.d("recycleer", "initRecAdapter common list size is: ${commonList.size}")
        //   this.toast("common list size is : ${commonList.size} in line 258")
        adapter = RecyclerViewAdapter(commonList, this@HomeActivity)
        exerAdapter = ExerciseAdapter(exerciseList, this@HomeActivity)
        layoutManager = LinearLayoutManager(this)
        consumed_food_recycler_view.layoutManager = layoutManager
        consumed_food_recycler_view.adapter = adapter
        exercise_recycler_view.layoutManager = LinearLayoutManager(this)
        exercise_recycler_view.adapter = exerAdapter
        toggleVisibility()

    }

    private fun toggleVisibility() {
        if (home_status_text_view.visibility == View.VISIBLE) {
            home_status_text_view.visibility = View.VISIBLE
            consumed_food_recycler_view.visibility = View.GONE

        } else {
            home_status_text_view.visibility = View.GONE
            consumed_food_recycler_view.visibility = View.VISIBLE
        }
    }

    private fun updateLASTITEMINDEX(index: Int) {
        LAST_ITEM_INDEX = index
    }

    private fun updateUI() {

    }

    private fun calculateCalories() {
        var total = 0
        for (item in commonList) {
            total = total.plus(item.calory)
        }

        setCunsumedCaloriestv(total.toString())

    }

    private fun setCunsumedCaloriestv(txt: String) {
        consumedCalories.text = "کالری دریافتی امروز: $txt".fa()
    }

    private fun setBurntCaloriestv(txt: String) {
        val tmp = "فعالیت های ورزشی"
        exerciseLBl.text = tmp.fa()
        burntCalories.text = "کالری سوزانده شده:‌ $txt".fa()
    }

    private fun calculateBurntCalories() {
        var temp = 0;
        for (item in exerciseList)
            temp = temp.plus(item.unitCal)

        setBurntCaloriestv(temp.toString())

    }

    private fun produceBarChartData() {
        var breakfastCalory = 0f
        var launchCalory = 0f
        var dinnerCalory = 0f
        var mealCalory = 0f
        var values: ArrayList<BarEntry> = ArrayList()
        for (item in commonList) {
            when (item.category) {
                "dinner" -> dinnerCalory = dinnerCalory.plus(item.ID)
                "breakfast" -> breakfastCalory = breakfastCalory.plus(item.ID)
                "mianvadeh" -> mealCalory = mealCalory.plus(item.ID)
                "launch" -> launchCalory = launchCalory.plus(item.ID)
            }
        }

        values.add(BarEntry(0f, mealCalory))
        values.add(BarEntry(1f, dinnerCalory))
        values.add(BarEntry(2f, launchCalory))
        values.add(BarEntry(3f, breakfastCalory))


//        for (i in 0..3){
//            if (commonList.size == 0){
//                applicationContext.toast("size problem")
//            }else{
//                values.add(BarEntry(i.toFloat(), commonList[i].calory.toFloat()))
//            }
//
//        }
        var dataSet: BarDataSet? = null
        val barEntry: ArrayList<BarEntry> = ArrayList()
        if (barChart.data != null && barChart.data.dataSetCount > 0) {
            //applicationContext.toast("chart data is not empty")
            dataSet = BarDataSet(values, "Data Set")
            dataSet.color = resources.getColor(R.color.bmi_below_18_5)
            dataSet.setDrawValues(false)


            val dataSets = ArrayList<IBarDataSet>()
            dataSets.add(dataSet)

            val data = BarData(dataSets)
            barChart.setData(data)
            barChart.setFitBars(true)

        } else {
            dataSet = BarDataSet(values, "Data Set")
            dataSet.color = resources.getColor(R.color.bmi_below_18_5)
            dataSet.setDrawValues(false)


            val dataSets = ArrayList<IBarDataSet>()
            dataSets.add(dataSet)

            val data = BarData(dataSets)
            barChart.setData(data)
            barChart.setFitBars(true)
        }

        barChart.invalidate()

    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    private fun clearData() {
        barChart.clear()
        commonList.clear()
//        adapter!!.notifyItemMoved()

    }

    private fun isDateChanged() {
    }

    private fun saveUserFoods() {
        val userAteFoods = UserAteFoods(today_Date, commonList)

        userPrefs!!.putObject(today_Date, userAteFoods)
    }

    private fun loadUserFood(timeStamp: String) {
        commonList =
            userPrefs!!.getObject(timeStamp, UserAteFoods::class.java)!!.getList(timeStamp)!!

    }

}
