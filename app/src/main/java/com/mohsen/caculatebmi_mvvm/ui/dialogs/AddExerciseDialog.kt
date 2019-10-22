package com.mohsen.caculatebmi_mvvm.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import com.mohsen.caculatebmi_mvvm.R
import kotlinx.android.synthetic.main.add_exercise_dialog.*
import java.util.stream.Stream

class AddExerciseDialog(context: Context, title: String) : Dialog(context){

    private val title = title
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_exercise_dialog)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        addExercisedialogTitle.text = title
        number_picker.setOnValueChangedListener { picker, oldVal, newVal ->
            setCaloriesValue(newVal)
        }
    }
    private fun setCaloriesValue(newval: Int){
        add_exercise_burned_calories_text_view.text = newval.times(5).toString() + " :کالری"
    }


}