package com.mohsen.caculatebmi_mvvm.util

import android.content.Context
import android.content.res.Resources
import android.widget.TextView
import android.widget.Toast
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.data.CaloriesPerGram
import com.mohsen.caculatebmi_mvvm.data.Exercises
import com.mohsen.caculatebmi_mvvm.data.ExercisesExpandableListDataPump
import com.mohsen.caculatebmi_mvvm.data.ExpandableListDataPump
import org.w3c.dom.Text
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

