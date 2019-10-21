package com.mohsen.caculatebmi_mvvm.util

//import com.mohsen.caculatebmi_mvvm.database.entity.SelectedFood
import com.mohsen.caculatebmi_mvvm.database.entity.Food
import com.mohsen.caculatebmi_mvvm.model.DialogFood


// for food unit

val TYPE_GRAM = 0
val TYPE_GLASS = 1
val TYPE_TEDAD = 2

//for meal type
val BREAKFAST = 0
val LAUNCH = 1
val DINNER = 2
val MIANVADEH = 3
val EXERSICE = 4
val EXTRA_FOOD = "extra_food"

var commonList: MutableList<Food> = ArrayList()
//var ateFoodIds: MutableList<SelectedFood> = ArrayList()