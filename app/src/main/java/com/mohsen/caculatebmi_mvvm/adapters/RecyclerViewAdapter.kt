package com.mohsen.caculatebmi_mvvm.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.model.DialogFood
import com.mohsen.caculatebmi_mvvm.ui.dialogs.AddFoodDialog
import com.mohsen.caculatebmi_mvvm.util.TYPE_GLASS
import com.mohsen.caculatebmi_mvvm.util.TYPE_GRAM
import com.mohsen.caculatebmi_mvvm.util.toast
import kotlinx.android.synthetic.main.recycler_row_item.view.*
import java.util.ArrayList

class RecyclerViewAdapter (val list: MutableList<DialogFood>, context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.FoodViewHolder>() {

    private val foodList = list
    private val mContext = context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_item,parent,false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.foodname.text = foodList[position].name
        holder.amount.text = foodList[position].calory
        if(foodList[position].type == TYPE_GRAM){
            holder.unit.text = "گرم"

        }else if (foodList[position].type == TYPE_GLASS){
            holder.unit.text = "لیوان"
        }
        holder.remove.setOnClickListener {
            list.removeAt(position)
            notifyItemRemoved(position)
        }

        holder.edit.setOnClickListener {
            val addFoodDialog = AddFoodDialog(mContext,foodList[position].name,"",onConfirmClick = {
                list.removeAt(position)
                list.add(position,it)
                notifyItemInserted(position)
                holder.foodname.text = it.name
                holder.amount.text = it.calory

                if(it.type == TYPE_GLASS){
                    holder.unit.text = "لیوان"
                    mContext.toast("لیوان انتخاب شد")
                }else if (it.type == TYPE_GRAM){
                    mContext.toast("گرم انتخاب شد")
                    holder.unit.text = "گرم"
                }
            })
            addFoodDialog.show()
        }

    }

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodname = itemView.recycler_item_food_name as TextView
        val amount  = itemView.recycler_food_amount as TextView
        val unit = itemView.recycler_food_unit as TextView
        val edit = itemView.recycler_edit_button as ImageButton
        val remove = itemView.recycler_remove_button as ImageButton
    }
}