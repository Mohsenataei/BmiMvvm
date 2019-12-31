package com.mohsen.caculatebmi_mvvm.util

//import com.mohsen.caculatebmi_mvvm.database.entity.SelectedFood
import com.alirezaafkar.sundatepicker.components.JDF
import com.mohsen.caculatebmi_mvvm.App
import com.mohsen.caculatebmi_mvvm.database.entity.Food
import com.mohsen.caculatebmi_mvvm.model.Exercise
import java.util.*
import kotlin.collections.ArrayList


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
val persianDateConverter = PersianDateConverter()
//var commonList: MutableList<Food> = ArrayList()
//var tempList: MutableList<Food> = ArrayList()
//val exerciseList: MutableList<Exercise> = ArrayList()
val favouriteFoods: MutableList<String> = ArrayList()
val today = Calendar.getInstance().time
var today_Date = JDF(Calendar.getInstance()).iranianDate.format(App.instance.currentLocale)
    set(value) {
        field = value.format(App.instance.currentLocale)
    }
var first_skip = false
//val prefs = SavedSharedPrerefrences()


//var ateFoodIds: MutableList<SelectedFood> = ArrayList()

var LAST_ITEM_INDEX = 0