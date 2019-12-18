package com.avalinejad.sport.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avalinejad.sport.App
import com.avalinejad.sport.R
import com.avalinejad.sport.database.entity.Food
import com.avalinejad.sport.ui.dialogs.AddFoodDialog
import com.avalinejad.sport.util.TYPE_GLASS
import com.avalinejad.sport.util.TYPE_GRAM
import com.avalinejad.sport.util.fa
import com.avalinejad.sport.util.toast
import kotlinx.android.synthetic.main.recycler_row_item.view.*

class RecyclerViewAdapter (val list: MutableList<Food>, context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.FoodViewHolder>() {

    private val foodList = list
    private val res = App.instance.resources

    private val mContext = context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_item,parent,false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("recycler","in adapter size is : ${foodList.size}")
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        Log.d("recycler","in adapter size is : ${foodList.size}")
        holder.foodname.text = foodList[position].name.fa()
        holder.amount.text = foodList[position].calory.toString()
        if(foodList[position].unit == TYPE_GRAM){
            holder.unit.text = res?.getString(R.string.grams)

        }else if (foodList[position].unit == TYPE_GLASS){
            holder.unit.text = res?.getString(R.string.glass)
        }
        holder.remove.setOnClickListener {
            Log.d("delete","deleted at index : $position")
            list.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,list.size)
        }

        holder.edit.setOnClickListener {
            val addFoodDialog = AddFoodDialog(mContext,foodList[position].name,"",onConfirmClick = {

                list.removeAt(position)
                notifyItemRemoved(position)
                //list.add(position,it)
                notifyItemInserted(position)
//                notifyItemInserted(position)
                notifyItemRangeChanged(position,list.size)
//                holder.foodname.text = it.name
//                holder.amount.text = it.calory.toString()
//
//
//                if(it.unit == TYPE_GLASS){
//                    holder.unit.text = "لیوان"
//                    mContext.toast("لیوان انتخاب شد")
//                }else if (it.unit == TYPE_GRAM){
//                    mContext.toast("گرم انتخاب شد")
//                    holder.unit.text = "گرم"
//                }
            })
            addFoodDialog.show()
        }

    }

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodname = itemView.recycler_item_food_name as TextView
        val amount  = itemView.recycler_food_amount as TextView
        val unit = itemView.recycler_food_unit as TextView
        val edit = itemView.recycler_edit_button as ImageView
        val remove = itemView.recycler_remove_button as ImageView
    }
}