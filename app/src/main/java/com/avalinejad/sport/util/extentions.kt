package com.avalinejad.sport.util

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.avalinejad.sport.R
import com.avalinejad.sport.data.CaloriesPerGram
import com.avalinejad.sport.data.Exercises
import com.avalinejad.sport.data.ExercisesExpandableListDataPump
import com.avalinejad.sport.data.ExpandableListDataPump
import java.util.HashMap



fun getExpandableListData() : HashMap<String, List<String>> {
    val expandableListDataPump = ExpandableListDataPump()
    return expandableListDataPump.getData()
}
fun Context.toast (message: String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}

fun getExerciseData(): HashMap<String, List<String>>{
    val exercisesExpandableListDataPump = ExercisesExpandableListDataPump()
    return exercisesExpandableListDataPump.getData()
}

fun getCaloriesData(): HashMap<String, HashMap<String,Int>> {
    val caloriesPerGram = CaloriesPerGram()
    return caloriesPerGram.getData()
}

fun getExerciseCalories() : HashMap<String, Int> {
    val exercises = Exercises()
    return exercises.getData()
}

fun TextView.setDrawableTop(drawableId: Int){
    this.setCompoundDrawablesWithIntrinsicBounds(0,drawableId,0,0)
}

fun TextView.setTextColor(colorId: Int){
    this.setTextColor(Resources.getSystem().getColor(R.color.bmi_more_than_40))
}


fun TextView.setBackgroundDrawable(drawableId: Int){
    this.background = Resources.getSystem().getDrawable(R.drawable.add_food_confirm_background)
}
//Convert pixel to dip
fun getDipsFromPixel(pixels: Float, context: Context): Int {
    // Get the screen's density scale
    val scale = context.resources.displayMetrics.density
    // Convert the dps to pixels, based on density scale
    return (pixels * scale + 0.5f).toInt()
}

fun dateHelper(day: Int, month: Int) : String?{
    var stringDate: String? = null
    var tmp: String? = null

    stringDate = day.toString()
    when(month){
        1 ->
            tmp = "  فروردین"
        2 ->
            tmp = " اردیبهشت"
        3 ->
            tmp = "  خرداد"
        4 ->
            tmp = "  تیر"
        5 ->
            tmp = "  مرداد"
        6 ->
            tmp = "  شهریور"
        7 ->
            tmp = "  مهر"
        8 ->
            tmp = "  آبان"
        9 ->
            tmp = "  آذر"
        10 ->
            tmp = "  دی"
        11->
            tmp = "  بهمن"
        12->
            tmp = "  اسفند"
        else ->
            Log.d("dateTime","else trrigerd")
    }
    Log.d("dateTime",stringDate)
    return stringDate.plus(tmp)
}

fun returnStandardDate(day: Int, month: Int ,year: Int): String{
    var tmp = ""

    tmp = "$year/"
    if (month < 10){
        Log.d("timestamp","$month")
      tmp =  tmp.plus("0$month/")
    }
    else tmp = tmp.plus("$month/")

    if(day < 10){
        Log.d("timestamp","$day")
        tmp = tmp.plus("0$day")
    }

    else
       tmp =  tmp.plus("$day")
    Log.d("compareDates","in return standard date fun date is :" + tmp)
    return tmp
}

private val persianNumbers = arrayOf("۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹")

fun String.fa() : String {
    if (this.length == 0) {
        return ""
    }
    var length = this.length
    var out = ""
    for (i in 0..(length - 1)) {
        var c = this[i]
        if ('0' <= c && c <= '9') {
            var number = Integer.parseInt(c.toString())
            out += persianNumbers[number]
        } else if (c == '٫') {
            out += '،'
        } else {
            out += c
        }
    }
    return out
}
fun dateHelper(date: String): String{
    val tmp = date.subSequence(5,date.length)
    Log.d("dateHelper", "dateHelper fun: tmp is $tmp")
    val month = tmp.subSequence(0,2)
    Log.d("dateHelper", "dateHelper fun: month is ${month.toString().toInt()}")
    val day = tmp.subSequence(3,5)
    Log.d("dateHelper", "dateHelper fun: day is $day")
    return dateHelper(day.toString().toInt(),month.toString().toInt())!!
}