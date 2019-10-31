package com.avalinejad.sport.util

//import com.mohsen.caculatebmi_mvvm.database.entity.SelectedFood
import com.avalinejad.sport.database.entity.Food


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
val FOOD_BUTTON = "food_button"
val EXERCISE_BUTTON = "exercise_button"

var commonList: MutableList<Food> = ArrayList()
var tempList: MutableList<Food> = ArrayList()
//var ateFoodIds: MutableList<SelectedFood> = ArrayList()

var  LAST_ITEM_INDEX = 0