package com.mohsen.caculatebmi_mvvm.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.adapters.CustomExpandableListAdapter
import com.mohsen.caculatebmi_mvvm.data.ExpandableListDataPump
import com.mohsen.caculatebmi_mvvm.database.entity.Food
import com.mohsen.caculatebmi_mvvm.model.DialogFood
import com.mohsen.caculatebmi_mvvm.ui.dialogs.AddFoodDialog
import com.mohsen.caculatebmi_mvvm.ui.home.HomeActivity
import com.mohsen.caculatebmi_mvvm.util.EXTRA_FOOD
import kotlinx.coroutines.launch
import java.util.HashMap
import com.mohsen.caculatebmi_mvvm.util.getExpandableListData
import com.mohsen.caculatebmi_mvvm.util.toast
import kotlinx.android.synthetic.main.fragment_food_category.*

class CategoryFragment(context: Context): BaseFragment() {
    private var expandableListTitle: List<String>? = null
    private var expandableListDetail: HashMap<String, List<String>>? = null
    private var expandableListAdapter: ExpandableListAdapter? = null
    private var mContext = context

    //val selectedFoods = java.util.ArrayList<AddedFood>()
    //val database = AppDatabase.getDatabase(context!!)
  //  val AddedFoodDao = database.addedFoodDao()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expandableListDetail = getExpandableListData()
        expandableListTitle = ArrayList<String>((expandableListDetail as HashMap<String, MutableList<String>>?)!!.keys)
        expandableListAdapter =
            CustomExpandableListAdapter(context, expandableListTitle, expandableListDetail!!)
        expandableListView.setAdapter(expandableListAdapter)


        expandableListView.setOnGroupExpandListener(ExpandableListView.OnGroupExpandListener { groupPosition ->
            //            Toast.makeText(
//                context,
//                (expandableListTitle as ArrayList<String>).get(groupPosition) + " List Expanded.",
//                Toast.LENGTH_SHORT
//            ).show()
        })
        expandableListView.setOnGroupCollapseListener(ExpandableListView.OnGroupCollapseListener { groupPosition ->
            //            Toast.makeText(
//                context,
//                (expandableListTitle as ArrayList<String>).get(groupPosition) + " List Collapsed.",
//                Toast.LENGTH_SHORT
//            ).show()
        })

        expandableListView.setOnChildClickListener(ExpandableListView.OnChildClickListener { parent, v, groupPosition, childPosition, id ->
//
            var i = 0
            val food: String = (expandableListDetail as HashMap<String, MutableList<String>>?)!!.get(
                    (expandableListTitle as ArrayList<String>).get(groupPosition)
                )!!.get(
                    childPosition
                )

            var mFood: Food? = null

            val addFoodDialog =  AddFoodDialog(mContext,food,"",onConfirmClick = {
                context?.toast("food received" + it.name)
                mFood = it
                val intent = Intent(context,HomeActivity::class.java)
                intent.putExtra(EXTRA_FOOD,mFood)
                //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                context!!.startActivity(intent)
            })
            addFoodDialog.show()


//            val consumedFoodDialog = meal?.let {
//                ConsumedFoodDialog(
//                    context!!,
//                    (expandableListDetail as HashMap<String, MutableList<String>>?)!!.get(
//                        (expandableListTitle as ArrayList<String>).get(groupPosition)
//                    )!!.get(
//                        childPosition
//                    ),
//                    it,
//                    OnDialogClicked { addedFood ->
//                        //Toast.makeText(context, "do something" + addedFood.amount, Toast.LENGTH_SHORT).show()
//                        selectedFoods.add(addedFood)
//                        launch {
//                            context?.let {
//                                AppDatabase.getDatabase(it).addedFoodDao().insertAll(addedFood)
//
//                                val cal = AppDatabase.getDatabase(it).addedFoodDao().getAll().size
//                                i++
//                                Toast.makeText(it,"calory : " + cal, Toast.LENGTH_SHORT).show()
//                                //AddedFoodDao.insertAll(addedFood)
//                            }
//                        }
//                    }
//                )
//            }


//            consumedFoodDialog?.show()


            false
        })
        //Toast.makeText(context, "number of items" + selectedFoods.size, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_category, container, false)
    }

//    override fun onResume() {
//        super.onResume()
//        //index ++
//        Toast.makeText(context,"onResume index is " + index , Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onPause() {
//        super.onPause()
//        index++
//        Toast.makeText(context,"onPause index is " + index , Toast.LENGTH_SHORT).show()
//    }
}