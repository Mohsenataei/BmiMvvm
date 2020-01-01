package com.mohsen.caculatebmi_mvvm.ui.home

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.alirezaafkar.sundatepicker.DatePicker
import com.alirezaafkar.sundatepicker.components.JDF
import com.mohsen.caculatebmi_mvvm.App
import com.mohsen.caculatebmi_mvvm.adapters.RecyclerViewAdapter
import com.mohsen.caculatebmi_mvvm.database.AppDatabase
import com.mohsen.caculatebmi_mvvm.database.dao.AteFoodDao
import com.mohsen.caculatebmi_mvvm.database.dao.DetailDao
import com.mohsen.caculatebmi_mvvm.database.dao.FoodDao
import com.mohsen.caculatebmi_mvvm.database.entity.Food
import com.mohsen.caculatebmi_mvvm.ui.addfood.AddFood
import com.mohsen.caculatebmi_mvvm.util.*
import kotlinx.android.synthetic.main.activity_home.*
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.adapters.ExerciseAdapter
import com.mohsen.caculatebmi_mvvm.ui.BMI.BMIActivity
import com.mohsen.caculatebmi_mvvm.ui.BaseActivity
import com.mohsen.caculatebmi_mvvm.ui.dialogs.AD_UNIT_ID
import com.mohsen.caculatebmi_mvvm.util.Date
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import java.util.*
import kotlin.collections.ArrayList


class HomeActivity : BaseActivity() {
    companion object {
        val addFoodLiveData by lazy { MutableLiveData<Unit>() }
        val addExerciseLiveData by lazy { MutableLiveData<Unit>() }
    }

//    var foodList: MutableList<Food> = ArrayList()

    var adapter: RecyclerViewAdapter? = null
    var exerAdapter: ExerciseAdapter? = null
    var layoutManager: LinearLayoutManager? = null
    var database: AppDatabase? = null
    var ateFoodDao: AteFoodDao? = null
    var foodDao: FoodDao? = null
    var detailDao: DetailDao? = null
    var i = 0
    //private lateinit var rewardedAd: RewardedAd

    private val res = App.instance.resources
    private lateinit var locale: Locale


    val chartLbls = arrayOf(
        res.getString(R.string.snack),
        res.getString(R.string.dinner),
        res.getString(R.string.launch),
        res.getString(R.string.breakfast)
    )
    var isDateChanged = false
    //    var userPrefs: Preferences? = null
    var userDay: Int = 0
    var userMonth: Int = 0
    var userYear: Int = 0
    var userSelectedDate = ""
    private lateinit var mInterstitialAd: InterstitialAd


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        MobileAds.initialize(this) {
            Log.i("MobileAds.initialize", "Start")
            it.adapterStatusMap.forEach { (t, u) ->
                Log.i("MobileAds.initialize", "$t: ${u.description} _ ${u.initializationState}")
            }
        }

        // loadStoredData()
        addFoodLiveData.observe(this, androidx.lifecycle.Observer {
            //            val commonList = Preferences.getInstance(this).loadAllFoods()
//            adapter?.foodList = commonList
            bindData()
        })
        addExerciseLiveData.observe(this,androidx.lifecycle.Observer {
            bindData()
        })

        mInterstitialAd = InterstitialAd(this).apply {
            adUnitId = AD_UNIT_ID
            adListener = (object : AdListener() {
                override fun onAdLoaded() {
                    Toast.makeText(this@HomeActivity, "onAdLoaded()", Toast.LENGTH_SHORT).show()
                }

                override fun onAdFailedToLoad(errorCode: Int) {
                    Toast.makeText(
                        this@HomeActivity,
                        "onAdFailedToLoad() with error code: $errorCode",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onAdClosed() {
                    Toast.makeText(
                        this@HomeActivity,
                        "ad closed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }
        locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            App.instance.resources.configuration.locales[0]
        } else {
            App.instance.resources.configuration.locale
        }
        Log.d("locale", locale.toString())
        Log.d("today", " today date is : $today")

        val typeface =
            Typeface.createFromAsset(applicationContext.assets, "fonts/iran_sans_normal.ttf")
        if (locale.toString() == "fa_IR") {
            todayDate.text = dateHelper(today_Date)
        } else if (locale.toString() == "en_US") {
            todayDate.text = today.toString().substring(0, 10)
        }
        //loadStoredData()
        initRecAdapter() // dont you date touch this line
        bindData()
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
        barChart.xAxis.valueFormatter = IndexAxisValueFormatter(chartLbls) as ValueFormatter?

        barChart.axisLeft.setDrawGridLines(false)
        barChart.axisLeft.typeface = typeface
        barChart.axisLeft.setStartAtZero(true)
        barChart.axisRight.setStartAtZero(true)
        barChart.animateY(1500)
        barChart.description.isEnabled = false
        //todayDate.text = dateHelper()
        barChart.legend.isEnabled = false

        todayDate.setOnClickListener {

            val mDate = Date()
            val builder1 = DatePicker.Builder()
                .id(1)
                .date(mDate.day, mDate.getMonth(), mDate.getYear())
                .build { id, calendar, day, month, year ->
                    today_Date = JDF(calendar).iranianDate
                    bindData()
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
                }
                .show(supportFragmentManager, "")

            Log.d("compareDates", "today date is :" + today_Date)
            Log.d("compareDates", "user selected date is :" + userSelectedDate)
//            if (!today_Date.equals(userSelectedDate)) {
//                Log.d("timestamp", "is it cleared ?")
//                saveUserFoods()
//                commonList.clear()
//                exerciseList.clear()
//            } else {
//                Log.d("compareTimeStamp", "else is executed.")
//                loadUserFood(userSelectedDate)
//            }
        }

        adFoodButton.setOnClickListener {
            val intent = Intent(this, AddFood::class.java)
            intent.putExtra("food_button", "120")
            startActivity(intent)
            //mInterstitialAd.show()
            //showInterstitial()
        }

        add_exercise.setOnClickListener {
            val intent = Intent(this, AddFood::class.java)
            intent.putExtra("exercise_button", "121")
            startActivity(intent)
        }

        calculateBmi.setOnClickListener {
            startActivity(Intent(this, BMIActivity::class.java))
        }

        Log.d("locale", currentLocale.toString())
    }



    private fun bindData() {
        val commonList = Preferences.getInstance(this).loadAllFoods()
        val exList = Preferences.getInstance(this).loadAllExercises()

        if (commonList.isEmpty()){
            foodLbl.visibility = View.VISIBLE
        }

        if (exList.isEmpty()) {
            exerciseLBl.visibility = View.GONE
        }

        adapter?.foodList = commonList
        exerAdapter?.exerciseList = exList



        calculateCalories(commonList)
        calculateBurntCalories()
        produceBarChartData(commonList)
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    private fun initDataBaseShits() {
        database = AppDatabase.getDatabase(this)
        ateFoodDao = database!!.ateFoodDao()
        foodDao = database!!.foodDao()
        detailDao = database!!.detailDao()
    }
    private fun initRecAdapter() {

        adapter = RecyclerViewAdapter(this)
        exerAdapter = ExerciseAdapter( this)
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

    private fun calculateCalories(commonList: List<Food>) {
        var total = 0
        for (item in commonList) {
            total = total.plus(item.calory)
        }

        setCunsumedCaloriestv(total.toString())

    }

    private fun setCunsumedCaloriestv(txt: String) {
        //consumedCalories.text = "کالری دریافتی امروز: $txt".fa()
       // consumedCalories.text = res.getString(R.string.today_calories).plus(": $txt")

    }

    private fun setBurntCaloriestv(txt: String) {
        //val tmp = "فعالیت های ورزشی"
        exerciseLBl.text = res.getString(R.string.activities)
        //burntCalories.text = "کالری سوزانده شده:‌ $txt".fa()
        burntCalories.text = res.getString(R.string.burned_calories).plus(": $txt")
    }

    private fun calculateBurntCalories() {
        var temp = 0
        for (item in Preferences.getInstance(this).loadAllExercises())
            temp = temp.plus(item.unitCal)

        setBurntCaloriestv(temp.toString())

    }

    private fun produceBarChartData(commonList: List<Food>) {
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
}
