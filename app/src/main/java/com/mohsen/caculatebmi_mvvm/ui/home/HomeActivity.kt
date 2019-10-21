package com.mohsen.caculatebmi_mvvm.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.adapters.RecyclerViewAdapter
import com.mohsen.caculatebmi_mvvm.database.AppDatabase
import com.mohsen.caculatebmi_mvvm.database.dao.AteFoodDao
import com.mohsen.caculatebmi_mvvm.database.dao.DetailDao
import com.mohsen.caculatebmi_mvvm.database.dao.FoodDao
import com.mohsen.caculatebmi_mvvm.database.entity.Food
import com.mohsen.caculatebmi_mvvm.ui.addfood.AddFood
import com.mohsen.caculatebmi_mvvm.util.EXTRA_FOOD
import com.mohsen.caculatebmi_mvvm.util.commonList
import com.mohsen.caculatebmi_mvvm.util.toast
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

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
       // Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show()
        initDataBaseShits()
        loadStoredData()
        //addExtraToList()
        //saveOnExit()

        if (commonList.isEmpty()){
            consumed_food_recycler_view.visibility = View.GONE
            home_status_text_view.visibility = View.VISIBLE
        }else{
            layoutManager = LinearLayoutManager(this)
            consumed_food_recycler_view.layoutManager = layoutManager

            consumed_food_recycler_view.adapter = adapter
            //adapter!!.notifyDataSetChanged()
        }
        adFoodButton.setOnClickListener {
            startActivity(Intent(this,AddFood::class.java))
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
            adapter = RecyclerViewAdapter(commonList,this)
            adapter!!.notifyDataSetChanged()
        }
    }



    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    override fun onDestroy() {
       super.onDestroy()
        if (commonList.size > 0){
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
        GlobalScope.launch {
            this@HomeActivity.let {
                for (item in commonList )
                detailDao!!.insertAll(item)
            }
        }
    }

    private fun retreiveOnStart(){

    }

    override fun onStart() {
        super.onStart()
         Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show()
        GlobalScope.launch {
            this@HomeActivity.let {
                commonList = AppDatabase.getDatabase(this@HomeActivity).detailDao().getAll()
                if (!commonList.isEmpty()){
                   Log.d("globalscope","still is not empty and size is ${commonList.size} and second element is : " + commonList[1].name)
                }
            }
        }
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

    }

    private fun loadStoredData(){
        GlobalScope.launch {
            this@HomeActivity.let {
                commonList = detailDao!!.getAll()
                if (commonList.isEmpty()){
                    Log.d("globalscope","list is empty")
                }
            }
        }
    }












}
