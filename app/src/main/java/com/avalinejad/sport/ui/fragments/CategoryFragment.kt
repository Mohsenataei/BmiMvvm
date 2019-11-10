package com.avalinejad.sport.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ImageView
import com.avalinejad.sport.R
import com.avalinejad.sport.adapters.CustomExpandableListAdapter
import com.avalinejad.sport.database.entity.Food
import com.avalinejad.sport.ui.dialogs.AddFoodDialog
import com.avalinejad.sport.ui.home.HomeActivity
import com.avalinejad.sport.util.*
import kotlinx.android.synthetic.main.app_bar.*
import java.util.HashMap
import kotlinx.android.synthetic.main.fragment_food_category.*
import kotlinx.android.synthetic.main.list_item.*

class CategoryFragment(context: Context): BaseFragment() {

    private var expandableListTitle: List<String>? = null
    private var expandableListDetail: HashMap<String, List<String>>? = null
    private var expandableListAdapter: ExpandableListAdapter? = null
    private var mContext = context

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //activity!!.toolbar.title = "انتخاب مواد "
//        activity!!.actionBar!!.title = "انتخاب مواددددد "

        val displayMetrics = DisplayMetrics()

        activity!!.windowManager.defaultDisplay.getMetrics(displayMetrics)


            expandableListDetail = getExpandableListData()
        expandableListTitle = ArrayList<String>((expandableListDetail as HashMap<String, MutableList<String>>?)!!.keys)
        expandableListAdapter =
            CustomExpandableListAdapter(context, expandableListTitle, expandableListDetail!!)
        expandableListView.setAdapter(expandableListAdapter)



        expandableListView.setOnGroupExpandListener{ _ ->

        }


        expandableListView.setOnGroupCollapseListener {_ ->

        }

        expandableListView.setOnChildClickListener{ parent, v, groupPosition, childPosition, id ->

            var i = 0
            val food: String = (expandableListDetail as HashMap<String, MutableList<String>>?)!!.get(
                    (expandableListTitle as ArrayList<String>).get(groupPosition)
                )!!.get(
                    childPosition
                )

//            expandedListFavBtn.setOnClickListener {
//                Log.d("CatFave","Invoked from Fragment first.")
//            }
//            v.findViewById<ImageView>(R.id.expandedListFavBtn).setOnClickListener {
//                Log.d("CatFave","Invoked from Fragment")
//            }


            var mFood: Food? = null

            val addFoodDialog =  AddFoodDialog(mContext,food,"",onConfirmClick = {
                context?.toast("food received" + it.name)
                mFood = it
                val intent = Intent(context,HomeActivity::class.java)
                //intent.putExtra(EXTRA_FOOD,mFood)
                context!!.startActivity(intent)
            })
            addFoodDialog.show()

            false
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_category, container, false)
    }
}