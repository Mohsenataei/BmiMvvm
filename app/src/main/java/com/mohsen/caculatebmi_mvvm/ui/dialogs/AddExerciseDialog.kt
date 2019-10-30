package com.mohsen.caculatebmi_mvvm.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.util.getExerciseCalories
import com.mohsen.caculatebmi_mvvm.util.getExerciseData
import com.mohsen.caculatebmi_mvvm.util.toast
import kotlinx.android.synthetic.main.add_exercise_dialog.*
import java.util.stream.Stream
import kotlin.time.times

class AddExerciseDialog(context: Context, title: String) : Dialog(context){

    private val title = title
    val calories = getExerciseCalories()[title]
    var flag: Boolean? = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_exercise_dialog)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        addExercisedialogTitle.text = title
        add_exercise_burned_calories_text_view.text = calories!!.div(30).toString() + " :کالری"
        number_picker.setOnValueChangedListener { picker, oldVal, newVal ->
            setCaloriesValue(newVal)
        }
        addExerciseConfirm.setOnClickListener {

            dismiss()
        }

    }
    private fun setCaloriesValue(newval: Int){
        add_exercise_burned_calories_text_view.text = newval.times(calories!!).div(30).toString() + " :کالری"
    }


}