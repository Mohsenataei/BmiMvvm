package com.mohsen.caculatebmi_mvvm.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.adapters.RecyclerViewAdapter
import com.mohsen.caculatebmi_mvvm.model.DialogFood
import com.mohsen.caculatebmi_mvvm.ui.addfood.AddFood
import com.mohsen.caculatebmi_mvvm.util.EXTRA_FOOD
import com.mohsen.caculatebmi_mvvm.util.commonList
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    var adapter: RecyclerViewAdapter? = null
    var layoutManager: LinearLayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        addExtraToList()

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
    }
    private fun getDialogFood(): DialogFood? {
        if(intent.hasExtra(EXTRA_FOOD)){
            return intent.getSerializableExtra(EXTRA_FOOD) as DialogFood
            Log.d(EXTRA_FOOD,"food extra has been found")
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

    }
}
