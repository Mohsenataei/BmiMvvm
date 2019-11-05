package com.avalinejad.sport.model

import android.util.Log
import com.avalinejad.sport.database.entity.Food
import java.sql.Timestamp

class UserAteFoods (timestamp: String, list : MutableList<Food> ) {
    var timeStamp = String
    var list : MutableList<Food> = ArrayList()

   fun addFood(food: Food){
        list.add(food)
   }
    fun addFood (list: MutableList<Food>) {
        this.list.addAll(this.list.size-1,list)
    }

    init {
        this.timeStamp = timeStamp
        this.list = list
    }

    fun getList(timestamp: String): MutableList<Food>? {
        //Log.d("compareTimeStamp", this.timeStamp.toString() + "|||" + timestamp)
        if (this.timeStamp.equals(timestamp))
            return list
        return null
    }

//    constructor(timestamp: String, food: Food){
//        timeStamp = timeStamp
//        list.add(food)
//    }

}