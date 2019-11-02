package com.avalinejad.sport.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import com.alirezaafkar.sundatepicker.DatePicker
import com.alirezaafkar.sundatepicker.interfaces.DateSetListener
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.enums.Anchor
import com.anychart.enums.HoverMode
import com.anychart.enums.Position
import com.anychart.enums.TooltipPositionMode


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
import java.util.*
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import com.avalinejad.sport.util.Date


class HomeActivity : AppCompatActivity() {

    var adapter: RecyclerViewAdapter? = null
    var layoutManager: LinearLayoutManager? = null
    var database: AppDatabase?= null
    var ateFoodDao: AteFoodDao?= null
    var foodDao: FoodDao?= null
    var detailDao: DetailDao?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show()
        initDataBaseShits()
        loadStoredData()
        addExtraToList()

        todayDate.setOnClickListener {

            val mDate = Date()
           val builder1 = DatePicker.Builder()
                .id(1)
               .date(mDate.getDay(), mDate.getMonth(), mDate.getYear())
                .build { id, calendar, day, month, year ->
                    calendar!!.time.toString()
                    this.toast("is it working ?"+calendar!!.time.toString())
                    //todayDate.text = calendar!!.time.toString().subSequence(4,10)
                    todayDate.text = mDate.date
                    mDate.setDate(day, month, year)

                    Log.d("dateTime",calendar!!.time.toString())
                }
                .show(supportFragmentManager,"")




        }




//        val cartesian = AnyChart.column()
//
//        val data = ArrayList<DataEntry>()
//        data.add(ValueDataEntry("Rouge", 80540))
//        data.add(ValueDataEntry("Foundation", 94190))
//        data.add(ValueDataEntry("Mascara", 102610))
//        data.add(ValueDataEntry("Lip gloss", 110430))
//        data.add(ValueDataEntry("Lipstick", 128000))
//        data.add(ValueDataEntry("Nail polish", 143760))
//        data.add(ValueDataEntry("Eyebrow pencil", 170670))
//        data.add(ValueDataEntry("Eyeliner", 213210))
//        data.add(ValueDataEntry("Eyeshadows", 249980))
//
//        val column = cartesian.column(data)
//
//        column.tooltip()
//            .titleFormat("{%X}")
//            .position(Position.CENTER_BOTTOM)
//            .anchor(Anchor.CENTER_BOTTOM)
//            .offsetX(0.0)
//            .offsetY(5.0)
//            .format("\${%Value}{groupsSeparator: }")
//
//        cartesian.animation(true)
//        cartesian.title("Top 10 Cosmetic Products by Revenue")
//
//        cartesian.yScale().minimum(0.0)
//
//        cartesian.yAxis(0).labels().format("\${%Value}{groupsSeparator: }")
//
//        cartesian.tooltip().positionMode(TooltipPositionMode.POINT)
//        cartesian.interactivity().hoverMode(HoverMode.BY_X)
//
//        cartesian.xAxis(0).title("Product")
//        cartesian.yAxis(0).title("Revenue")

       // homePageChart.setChart(cartesian)
        //saveOnExit()

//        if (commonList.isEmpty()){
//            Log.d("recycler", "list still empty wtf ?")
//            consumed_food_recycler_view.visibility = View.GONE
//            home_status_text_view.visibility = View.VISIBLE
//        }else{
//            layoutManager = LinearLayoutManager(this)
//            consumed_food_recycler_view.layoutManager = layoutManager
//            consumed_food_recycler_view.adapter = adapter
//            //adapter!!.notifyDataSetChanged()
//        }


        adFoodButton.setOnClickListener {
            val intent = Intent(this,AddFood::class.java)
            intent.putExtra("food_button","120")
            startActivity(intent)
        }

        add_exercise.setOnClickListener {
            val intent = Intent(this,AddFood::class.java)
            intent.putExtra("exercise_button","121")
            startActivity(intent)
        }


//        Log.d("list","this is global scope")
//        GlobalScope.launch {
//            this@HomeActivity.let {
//                foodDao!!.insertAll(Food(10020,5,"باقالی پلو",5+1,"پلوها"))
//
//                val list =  foodDao!!.getAll()
//                val size = list.size
//                Log.d("list","size of list is $size")
//                for (item in list){
//                    Log.d("list","" + item.ID)
//                }
//            }
//        }
    }
    private fun getDialogFood(): Food? {
        if(intent.hasExtra(EXTRA_FOOD)){
            Log.d(EXTRA_FOOD,"food extra has been found")
            return intent.getSerializableExtra(EXTRA_FOOD) as Food
//        }else {
//            GlobalScope.launch {
//                Log.d("globalscope","data retrieved from database.")
//                this@HomeActivity.let {
//                    commonList = detailDao!!.getAll()
//                }
//                Log.d("globalscope","data retrieved from database. size is ${commonList.size}")
//            }
        }
        Log.d(EXTRA_FOOD,"returned null")
        return null
    }

    private fun addExtraToList(){
        val food = getDialogFood()
        if (food != null){
            commonList.add(food)
            Log.d("extra_food","common list size now is : ${commonList.size} and received food is ${food.name}")
            adapter = RecyclerViewAdapter(commonList,this)
            adapter!!.notifyItemInserted(commonList.size-1)
            initRecAdapter()
        }
    }



    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    override fun onDestroy() {
       super.onDestroy()
        if (tempList.size > 0){
            Toast.makeText(this,"data has been saved from here",Toast.LENGTH_SHORT).show()
            saveOnExit()

        }else{
            Toast.makeText(this,"data has not been saved because list is empty",Toast.LENGTH_SHORT).show()
        }
       // Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show()
    }

    private fun initCommotList(){

    }

    private fun initDataBaseShits(){
        database = AppDatabase.getDatabase(this)
        ateFoodDao = database!!.ateFoodDao()
        foodDao = database!!.foodDao()
        detailDao = database!!.detailDao()
    }



    private fun saveOnExit(){
        Log.d("extra_food","saveOnExit list size is : ${tempList.size}"  )
        GlobalScope.launch {
            this@HomeActivity.let {
               for (item in tempList )
                   detailDao!!.insertAll(item)
                  // Log.d("extra_food","saveOnExit Saving: ${item.name}"  )
            }
        }
        tempList.clear()
    }

    private fun retreiveOnStart(){

    }

    override fun onStart() {
        super.onStart()
         Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show()
//        GlobalScope.launch {
//            this@HomeActivity.let {
//                val size = AppDatabase.getDatabase(this@HomeActivity).detailDao().getAll().size
//                Log.d("globalscope","still is not empty and size is $size and second element is : ")
//            }
//        }
        if (commonList.isEmpty()){
            this.toast("still empty outside global scope ()")
        }
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()

        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show()
        initRecAdapter()
        commonList.addAll(tempList)
        adapter!!.notifyItemRangeInserted(commonList.size-1, tempList.size)
    }

    private fun loadStoredData(){
        GlobalScope.launch {
            this@HomeActivity.let {
                commonList = detailDao!!.getAll()
                updateLASTITEMINDEX(commonList.size)
                if (commonList.isEmpty()){
                    Log.d("globalscope","list is empty")
                }else{
                    initRecAdapter()
                }
            }
        }

    }


    private fun initRecAdapter(){
        Log.d("recycler","initRecAdapter common list size is: ${commonList.size}")
        adapter = RecyclerViewAdapter(commonList,this@HomeActivity)
        layoutManager = LinearLayoutManager(this)
        consumed_food_recycler_view.layoutManager = layoutManager
        consumed_food_recycler_view.adapter = adapter
        toggleVisibility()

    }

    private fun toggleVisibility (){
        if (home_status_text_view.visibility == View.VISIBLE){
            home_status_text_view.visibility = View.VISIBLE
            consumed_food_recycler_view.visibility =  View.GONE

        }else {
            home_status_text_view.visibility = View.GONE
            consumed_food_recycler_view.visibility = View.VISIBLE
        }
    }

private fun updateLASTITEMINDEX(index:Int){
    LAST_ITEM_INDEX = index
}
    private fun updateUI(){

    }

}
