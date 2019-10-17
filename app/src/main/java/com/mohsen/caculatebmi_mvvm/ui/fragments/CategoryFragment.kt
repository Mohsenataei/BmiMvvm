package com.mohsen.caculatebmi_mvvm.ui.fragments

import android.content.Context
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
import kotlinx.coroutines.launch
import java.util.HashMap
import com.mohsen.caculatebmi_mvvm.util.getExpandableListData
import kotlinx.android.synthetic.main.fragment_food_category.*

class CategoryFragment(context: Context): BaseFragment() {
    private var expandableListTitle: List<String>? = null
    private var expandableListDetail: HashMap<String, List<String>>? = null
    private var expandableListAdapter: ExpandableListAdapter? = null

    //val selectedFoods = java.util.ArrayList<AddedFood>()
    //val database = AppDatabase.getDatabase(context!!)
  //  val AddedFoodDao = database.addedFoodDao()
    var index = 0



    private var meal: String? = null
    private val TAG = "ConsumedCaloriesCalcula"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expandableListDetail = getExpandableListData()
        expandableListTitle = ArrayList<String>((expandableListDetail as HashMap<String, MutableList<String>>?)!!.keys) as List<String>?
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
            //Toast.makeText(
//                context,
//                (expandableListTitle as ArrayList<String>).get(groupPosition)
//                        + " -> "
//                        + (expandableListDetail as HashMap<String, MutableList<String>>?)!!.get(
//                    (expandableListTitle as ArrayList<String>).get(groupPosition)
//                )!!.get(
//                    childPosition
//                ), Toast.LENGTH_SHORT
//            ).show()
            var i = 0
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
        meal = arguments!!.getString("type")
        if (meal == null) {
            Log.d(TAG, "onCreateView: damn it, what the hell is going wrong ?")
            meal = "کله "
        }
        return inflater.inflate(R.layout.fragment_food_category, container, false)
    }

    override fun onResume() {
        super.onResume()
        //index ++
        Toast.makeText(context,"index is " + index , Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        index++
        Toast.makeText(context,"index is " + index , Toast.LENGTH_SHORT).show()
    }
}