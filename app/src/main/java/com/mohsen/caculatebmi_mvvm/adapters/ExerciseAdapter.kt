package com.mohsen.caculatebmi_mvvm.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohsen.caculatebmi_mvvm.App
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.database.entity.Food
import com.mohsen.caculatebmi_mvvm.model.Exercise
import com.mohsen.caculatebmi_mvvm.ui.dialogs.AddExerciseDialog
import com.mohsen.caculatebmi_mvvm.ui.home.HomeActivity
import com.mohsen.caculatebmi_mvvm.util.Preferences
import kotlinx.android.synthetic.main.recycler_row_item.view.*

class ExerciseAdapter (val context: Context, list: List<Exercise> = listOf()) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {
    var exerciseList: MutableList<Exercise> = list.toMutableList()
        set(value) {
            if (value == field)
                return
            field = value
            notifyDataSetChanged()
        }
    val mContext = context
    val res = App.instance.resources
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_item,parent,false)
        return ExerciseViewHolder(view)
    }

    override fun getItemCount(): Int {
       return exerciseList.size
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val exercise = exerciseList[position]
        holder.title.text = exercise.name
        holder.amount.text = exercise.duration.toString()
        holder.unit.text = res.getString(R.string.minute)

        holder.remove.setOnClickListener {
            Log.d("delete","deleted at index : $position")
            exerciseList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,exerciseList.size)
            Preferences.getInstance(context).removeExercise(exercise)
        }

        holder.edit.setOnClickListener {
            val addExerciseDialog = AddExerciseDialog(mContext,exerciseList[position].name, onResult = {
                Preferences.getInstance(context).saveExercise(exercise)
                HomeActivity.addExerciseLiveData.value = Unit
//                exerciseList.removeAt(position)
//                notifyItemRemoved(position)
//               // list.add(position,it)
//                notifyItemInserted(position)
//                notifyItemRangeChanged(position,exerciseList.size)
//                holder.title.text = it.name
//                holder.amount.text = it.duration.toString()
//                holder.unit.text = "دقیقه"
            })
            addExerciseDialog.show()
        }
    }


    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.recycler_item_food_name as TextView
        val amount  = itemView.recycler_food_amount as TextView
        val unit = itemView.recycler_food_unit as TextView
        val edit = itemView.recycler_edit_button as ImageView
        val remove = itemView.recycler_remove_button as ImageView
    }
}
