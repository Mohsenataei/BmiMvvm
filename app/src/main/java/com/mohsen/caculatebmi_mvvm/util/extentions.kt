package com.mohsen.caculatebmi_mvvm.util

import android.content.Context
import android.widget.TextView
import android.widget.Toast
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



