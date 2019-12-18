package com.avalinejad.sport.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.ViewGroup
import com.avalinejad.sport.App
import com.avalinejad.sport.R
import com.avalinejad.sport.database.entity.Food
import com.avalinejad.sport.model.Exercise
import com.avalinejad.sport.util.exerciseList
import com.avalinejad.sport.util.getExerciseCalories
import kotlinx.android.synthetic.main.add_exercise_dialog.*

class AddExerciseDialog(context: Context, title: String, val onConfirmClick : (food: Exercise) -> Unit = {}) : Dialog(context){

    private val title = title
    val calories = getExerciseCalories()[title]
    var flag: Boolean? = false
    var duration = 1
    var cal = 0
    val res: Resources? = App.instance.resources
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_exercise_dialog)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        addExercisedialogTitle.text = title
        add_exercise_burned_calories_text_view.text = calories!!.div(30).toString().plus(" " + res?.getString(R.string.calory))
        number_picker.setOnValueChangedListener { picker, oldVal, newVal ->
            duration = newVal
            setCaloriesValue(newVal)
        }
        addExerciseConfirm.setOnClickListener {
            exerciseList.add(Exercise(title,duration,cal))
            onConfirmClick(Exercise(title,duration,cal))
            dismiss()
        }


    }
    private fun setCaloriesValue(newval: Int){
        cal = newval.times(calories!!).div(30)
        add_exercise_burned_calories_text_view.text = cal.toString().plus(" " + res?.getString(R.string.calory))
    }




}