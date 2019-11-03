package com.avalinejad.sport.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.avalinejad.sport.R
import com.avalinejad.sport.database.entity.Food
import com.avalinejad.sport.util.*
import kotlinx.android.synthetic.main.add_food_dialog.*
import java.util.HashMap

@Suppress("DEPRECATION")
class AddFoodDialog(context: Context, food_title: String, type: String, val onConfirmClick : (food: Food) -> Unit = {}) : Dialog(context)  {

    val hashMap: HashMap<String, Int> = HashMap()
    //val caloriesList = CaloriesList()
    val key:  String? = null
    val dilogType = type
    //val onDialogClicked = onClick
    var ateCalory: String? = null
    var calories: Int? = null
    var meal: Int? = null
    var type: Int? = null
    val title = food_title
    val caloriesData = getCaloriesData()
    val caloryByGram = caloriesData["gram"]
    val caloryByGlass = caloriesData["glass"]
    var flags = arrayOfNulls<Boolean>(4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_food_dialog)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        for (i in 0..flags.size-1)
            flags[i] = false
        food_name.text = title
        if (caloryByGlass!![title] == null){
            add_food_dialog_glass_text_view.visibility = View.GONE
            var params = add_food_dialog_glass_text_view.layoutParams as LinearLayout.LayoutParams
            params.setMargins(0, 10,0,  0); //substitute parameters for left, top, right, bottom
            add_food_dialog_glass_text_view.layoutParams = params
        }
        getMeal()
        getType()
        //getCalories()
        add_food_dialog_edit_text.addTextChangedListener{object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val text = add_food_dialog_edit_text.text.toString().toInt()
                Log.d("onchange","is it working ?")
                val unit = caloriesData["gram"]!![title]
                calories = text.times(unit!!).div(100)
                Consumed_calories_text_view.text = text.times(unit!!).div(100).toString()+" کالری "
                ateCalory = add_food_dialog_calory_text_view.text.toString()
                if (type == TYPE_GLASS && !add_food_dialog_calory_text_view.text.isNullOrEmpty()) {
                    add_food_dialog_calory_text_view.text =
                        add_food_dialog_edit_text.text.toString().toInt().times(5).toString()
                    ateCalory = add_food_dialog_calory_text_view.text.toString()
                }
            }

        }
        }
        onConfirmClicked()

    }



    private fun getMeal() {
        add_food_dialog_breakfast.setOnClickListener {
            meal = BREAKFAST
            selectBreakfast()
            setDinnerToNormal()
            setMianVadeToNormal()
            setLaunchToNormal()
            context.toast("شما در حال انتخاب صبحانه هستید")
        }
        add_food_dialog_dinner.setOnClickListener {
            meal = DINNER
            selectDinner()
            setMianVadeToNormal()
            setLaunchToNormal()
            setBreakfastToNormal()
            context.toast("شما در حال انتخاب شام هستید")
        }
        add_food_dialog_mianvade.setOnClickListener {
            meal = MIANVADEH
            selectMianvade()
            setLaunchToNormal()
            setBreakfastToNormal()
            setDinnerToNormal()
            context.toast("شما در حال انتخاب میان وعده هستید")
        }
        add_food_dialog_launch.setOnClickListener {
            meal = LAUNCH
            selectLaunch()
            setBreakfastToNormal()
            setDinnerToNormal()
            setMianVadeToNormal()
            context.toast("شما در حال انتخاب نهار هستید")
            }

    }

    private fun getType(){
        add_food_dialog_glass_text_view.setOnClickListener {
            type = TYPE_GLASS
            context.toast("واحد انتخابی شما: لیوان")
            getCalories()
            setCaloriesTextView(TYPE_GLASS)
        }
        add_food_dialog_gram_text_view.setOnClickListener {
            type = TYPE_GRAM
            context.toast("واحد انتخابی شما: گرم")
            getCalories()
            setCaloriesTextView(TYPE_GRAM)
        }
    }

    private fun setCaloriesTextView(type: Int) {
        if (!add_food_dialog_edit_text.text.isNullOrEmpty()){
            val text = add_food_dialog_edit_text.text.toString().toInt()
            if (type == TYPE_GLASS){
                val cal = caloryByGlass!![title]
                add_food_dialog_calory_text_view.text = text.times(cal!!).toString()

            }else if (type == TYPE_GRAM){
                val cal = caloryByGram!![title]
                calories = text.times(cal!!).div(100)
                Consumed_calories_text_view.text = text.times(cal!!).div(100).toString() + "  کالری "
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
        val cal = caloryByGram!![title]
        add_food_dialog_calory_text_view.text = ateCalory!!.toInt().times(cal!!).div(100).toString()
    }
    private fun setValuesByGlass(){
        val cal = caloryByGlass!![title]
        add_food_dialog_calory_text_view.text = ateCalory!!.toInt().times(cal!!).toString()
    }

    private fun confirmation(){
        Log.d("Type","type is " + type)
        //onConfirmClick(Food(0,type!!,title,ateCalory!!.toInt(),meal.toString()))

        //  commonList.add(Food(0,type!!,title,ateCalory!!.toInt(),meal.toString()))
        tempList.add(Food(calories!!,type!!,title,ateCalory!!.toInt(),meal.toString()))
        Log.d("extra_food","item added to common list in addFood dialog and list size now is : ${commonList.size}")
        Log.d("testing","Start Debugging")
        for (item in commonList){
            Log.d("testing",item.name)
        }
        Log.d("testing","End Debugging")
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



    private fun setBreakfastToNormal(){
        add_food_dialog_breakfast.setDrawableTop(R.drawable.ic_breakfast)
        add_food_dialog_breakfast.setTextColor(ContextCompat.getColor(context,R.color.grey))
        add_food_dialog_breakfast.setBackgroundResource(R.drawable.add_food_dialog_items_background)
    }
    private fun setDinnerToNormal(){
        add_food_dialog_dinner.setDrawableTop(R.drawable.ic_dinner)
        add_food_dialog_dinner.setTextColor(ContextCompat.getColor(context,R.color.grey))
        add_food_dialog_dinner.setBackgroundResource(R.drawable.add_food_dialog_items_background)
    }
    private fun setLaunchToNormal(){
        add_food_dialog_launch.setDrawableTop(R.drawable.ic_utensils_alt)
        add_food_dialog_launch.setTextColor(ContextCompat.getColor(context,R.color.grey))
        add_food_dialog_launch.setBackgroundResource(R.drawable.add_food_dialog_items_background)
    }
    private fun setMianVadeToNormal(){
        add_food_dialog_mianvade.setDrawableTop(R.drawable.ic_bread)
        add_food_dialog_mianvade.setTextColor(ContextCompat.getColor(context,R.color.grey))
        add_food_dialog_mianvade.setBackgroundResource(R.drawable.add_food_dialog_items_background)
    }





    private fun selectBreakfast(){
        add_food_dialog_breakfast.setDrawableTop(R.drawable.ic_breakfast_onclicked)
        add_food_dialog_breakfast.setTextColor(ContextCompat.getColor(context,R.color.white))
        add_food_dialog_breakfast.setBackgroundResource(R.drawable.add_food_confirm_background)
    }
    private fun selectDinner(){
        add_food_dialog_dinner.setDrawableTop(R.drawable.ic_dinner_onclick)
        add_food_dialog_dinner.setTextColor(ContextCompat.getColor(context,R.color.white))
        add_food_dialog_dinner.setBackgroundResource(R.drawable.add_food_confirm_background)
    }
     private fun selectLaunch(){
         add_food_dialog_launch.setDrawableTop(R.drawable.ic_utensils_alt_onclick)
         add_food_dialog_launch.setTextColor(ContextCompat.getColor(context,R.color.white))
         add_food_dialog_launch.setBackgroundResource(R.drawable.add_food_confirm_background)
    }
     private fun selectMianvade(){
         add_food_dialog_mianvade.setDrawableTop(R.drawable.ic_bread_onclick)
         add_food_dialog_mianvade.setTextColor(ContextCompat.getColor(context,R.color.white))
         add_food_dialog_mianvade.setBackgroundResource(R.drawable.add_food_confirm_background)
    }


}

