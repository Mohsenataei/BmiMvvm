package com.mohsen.caculatebmi_mvvm.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.database.entity.Food
import com.mohsen.caculatebmi_mvvm.model.DialogFood
import com.mohsen.caculatebmi_mvvm.util.*
import kotlinx.android.synthetic.main.add_food_dialog.*
import java.util.HashMap
import kotlin.time.milliseconds

class AddFoodDialog( context: Context, food_title: String, type: String, val onConfirmClick : (food: Food) -> Unit = {}) : Dialog(context)  {

    val hashMap: HashMap<String, Int> = HashMap()
    //val caloriesList = CaloriesList()
    val key:  String? = null
    val dilogType = type
    //val onDialogClicked = onClick
    var ateCalory: String? = null
    var meal: Int? = null
    var type: Int? = null
    val title = food_title

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_food_dialog)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        food_name.text = title
        getMeal()
        getType()
        //getCalories()
        add_food_dialog_edit_text.addTextChangedListener{
            if (type != null){
                add_food_dialog_calory_text_view.text = add_food_dialog_edit_text.text.toString().toInt().times(10).toString()
            }else if (type == TYPE_GRAM) {
                add_food_dialog_calory_text_view.text = add_food_dialog_edit_text.text.toString().toInt().times(100).toString()
            }else if (type == TYPE_GLASS) {
                add_food_dialog_calory_text_view.text =
                    add_food_dialog_edit_text.text.toString().toInt().times(5).toString()
            }
        }
        onConfirmClicked()

    }

    private fun getMeal() {
        add_food_dialog_breakfast.setOnClickListener {
            meal = BREAKFAST
            context.toast("شما در حال انتخاب صبحانه هستید")
        }
        add_food_dialog_dinner.setOnClickListener {
            meal = DINNER
            context.toast("شما در حال انتخاب شام هستید")
        }
        add_food_dialog_mianvade.setOnClickListener {
            meal = MIANVADEH
            context.toast("شما در حال انتخاب میان وعده هستید")
        }
        add_food_dialog_launch.setOnClickListener {
            meal = LAUNCH
            context.toast("شما در حال انتخاب نهار هستید")
        }
    }

    private fun getType(){
        add_food_dialog_glass_text_view.setOnClickListener {
            type = TYPE_GLASS
            context.toast("واحد انتخابی شما: لیوان")
            setCaloriesTextView(TYPE_GLASS)
        }
        add_food_dialog_gram_text_view.setOnClickListener {
            type = TYPE_GRAM
            context.toast("واحد انتخابی شما: گرم")
            setCaloriesTextView(TYPE_GRAM)
        }
    }

    private fun setCaloriesTextView(type: Int) {
        if (!add_food_dialog_edit_text.text.isNullOrEmpty()){
            if (type == TYPE_GLASS){
                add_food_dialog_calory_text_view.text = add_food_dialog_edit_text.text.toString().toInt().times(5).toString()
            }else if (type == TYPE_GRAM){
                add_food_dialog_calory_text_view.text = add_food_dialog_edit_text.text.toString().toInt().times(10).toString()
            }
        }
    }

    private fun getCalories() {

            ateCalory = add_food_dialog_edit_text.text.toString()
//        }else if (add_food_dialog_edit_text.text.toString().toIntOrNull() == null){
//            context.toast("لطفا مقدار مصرفی را به عدد وارد کنید")
//            ateCalory = add_food_dialog_edit_text.text.toString()
    }

    private fun setValuesByGram(){
        add_food_dialog_calory_text_view.text = ateCalory!!.toInt().times(50).div(100).toString()
    }
    private fun setValuesByGlass(){
        add_food_dialog_calory_text_view.text = ateCalory!!.toInt().times(50).div(4).toString()
    }

    private fun confirmation(){
        Log.d("Type","type is " + type)
        onConfirmClick(Food(0,type!!,title,ateCalory!!.toInt(),meal.toString()))
        dismiss()
    }
    private fun getValues() {
        getMeal()
        getType()
        add_food_dialog_glass_text_view.setOnClickListener {
            type = TYPE_GLASS
            if (meal == null){
                context.toast("لطفا وعده مصرفی را وارد کنید")
                getMeal()
            }else if (ateCalory == null){
                context.toast("لطفا مقدار کالری را وارد کنید")
                getCalories()
            }
            setValuesByGlass()

        }
        add_food_dialog_gram_text_view.setOnClickListener {
            type = TYPE_GRAM
            if (meal == null){
                context.toast("لطفا وعده مصرفی را وارد کنید")
                getMeal()
            }else if (ateCalory == null){
                context.toast("لطفا مقدار کالری را وارد کنید")
                getCalories()
            }
            setValuesByGram()
        }
    }

    private fun onConfirmClicked(){
        add_food_confirm_button.setOnClickListener {
            //context.toast("confirm clicked")
            if (checkValues()){
                confirmation()
            }
        }
    }

    private fun start(){
        onConfirmClicked()
        getValues()
    }
    private fun checkValues(): Boolean{
        if (!checkCalories()){
            context.toast("لطفا میزان مصرفییییی را وارد کنید: ")
            getCalories()
            return false
        }else if (!checkMeal()){
            context.toast("لطفا وعده مصرفی را انتخاب کنید")
            getMeal()
            return false
        } else if (!checkType()){
            context.toast(" :لطفا واحد مصرفی را انتخاب کنید")
            getType()
            return false
        }else return true

    }
    private fun checkType(): Boolean{
    if (type == null) {
        return false
    }
        return true
    }
    private fun checkMeal (): Boolean{
        if (meal == null) {
            return false
        }
        return true
    }
    private fun checkCalories() : Boolean {
        if (ateCalory == null) {
            return false
        }
        return true
    }

}

