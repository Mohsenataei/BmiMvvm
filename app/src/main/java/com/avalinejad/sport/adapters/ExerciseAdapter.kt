package com.avalinejad.sport.adapters

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avalinejad.sport.R
import com.avalinejad.sport.model.Exercise
import com.avalinejad.sport.ui.dialogs.AddExerciseDialog
import kotlinx.android.synthetic.main.recycler_row_item.view.*

class ExerciseAdapter (val list: MutableList<Exercise>, context: Context) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    val mContext = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_item,parent,false)
        return ExerciseViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.title.text = list[position].name
        holder.amount.text = list[position].duration.toString()
        holder.unit.text = "دقیقه"

        holder.remove.setOnClickListener {
            Log.d("delete","deleted at index : $position")
            list.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,list.size)
        }

        holder.edit.setOnClickListener {
            val addExerciseDialog = AddExerciseDialog(mContext,list[position].name, onConfirmClick = {
                list.removeAt(position)
                notifyItemRemoved(position)
               // list.add(position,it)
                notifyItemInserted(position)
                notifyItemRangeChanged(position,list.size)
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
