package com.avalinejad.sport.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import com.avalinejad.sport.R
import com.avalinejad.sport.adapters.CustomExpandableListAdapter
import com.avalinejad.sport.database.entity.Food
import com.avalinejad.sport.ui.dialogs.AddFoodDialog
import com.avalinejad.sport.ui.home.HomeActivity
import com.avalinejad.sport.util.*
import java.util.HashMap
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

        var width: Int = 0
        val displayMetrics = DisplayMetrics()
        //context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics)
        activity!!.windowManager.defaultDisplay.getMetrics(displayMetrics)
        width = displayMetrics.widthPixels

            expandableListDetail = getExpandableListData()
        expandableListTitle = ArrayList<String>((expandableListDetail as HashMap<String, MutableList<String>>?)!!.keys)
        expandableListAdapter =
            CustomExpandableListAdapter(context, expandableListTitle, expandableListDetail!!)
        expandableListView.setAdapter(expandableListAdapter)
        //expandableListView.setIndicatorBounds(width - getDipsFromPixel(20F,context!!) ,getDipsFromPixel(2F,context!!) )


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