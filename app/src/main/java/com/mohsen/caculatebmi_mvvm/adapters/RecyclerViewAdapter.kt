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
import com.mohsen.caculatebmi_mvvm.ui.dialogs.AddFoodDialog
import com.mohsen.caculatebmi_mvvm.ui.home.HomeActivity
import com.mohsen.caculatebmi_mvvm.util.Preferences
import com.mohsen.caculatebmi_mvvm.util.TYPE_GLASS
import com.mohsen.caculatebmi_mvvm.util.TYPE_GRAM
import com.mohsen.caculatebmi_mvvm.util.fa
import kotlinx.android.synthetic.main.recycler_row_item.view.*

class RecyclerViewAdapter(val context: Context, list: List<Food> = listOf()) :
    RecyclerView.Adapter<RecyclerViewAdapter.FoodViewHolder>() {
    var foodList: MutableList<Food> = list.toMutableList()
        set(value) {
            if (value == field)
                return
            field = value
            notifyDataSetChanged()
        }



    private val res = App.instance.resources

    private val mContext = context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_item, parent, false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("recycler", "in adapter size is : ${foodList.size}")
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        Log.d("recycler", "in adapter size is : ${foodList.size}")
        val food = foodList[position]

        holder.foodname.text = food.name.fa()
        holder.amount.text = food.calory.toString()
        if (food.unit == TYPE_GRAM) {
            holder.unit.text = res?.getString(R.string.grams)

        } else if (food.unit == TYPE_GLASS) {
            holder.unit.text = res?.getString(R.string.glass)
        }
        holder.remove.setOnClickListener {
            Log.d("delete", "deleted at index : $position")
            foodList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, foodList.size)

            Preferences.getInstance(context).removeFood(food)
        }

        holder.edit.setOnClickListener {
            val addFoodDialog =
                AddFoodDialog(mContext, foodList[position].name, "", onResult = {
                    Preferences.getInstance(context).saveFood(food)
                    HomeActivity.addFoodLiveData.value = Unit


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
        val amount = itemView.recycler_food_amount as TextView
        val unit = itemView.recycler_food_unit as TextView
        val edit = itemView.recycler_edit_button as ImageView
        val remove = itemView.recycler_remove_button as ImageView
    }
}