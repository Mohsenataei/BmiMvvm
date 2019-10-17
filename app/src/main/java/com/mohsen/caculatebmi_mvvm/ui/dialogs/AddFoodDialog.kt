package com.mohsen.caculatebmi_mvvm.ui.dialogs

import android.app.Dialog
import android.content.Context
import com.mohsen.caculatebmi_mvvm.util.OnDialogClicked
import java.util.HashMap

class AddFoodDialog(context: Context, food_title: String, type: String, onClick: OnDialogClicked) : Dialog(context)  {

    val hashMap: HashMap<String, Int> = HashMap()
    //val caloriesList = CaloriesList()
    val food = food_title
    val key:  String? = null
    val dilogType = type
    val onDialogClicked = onClick

}