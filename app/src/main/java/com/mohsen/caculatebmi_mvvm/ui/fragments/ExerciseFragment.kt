package com.mohsen.caculatebmi_mvvm.ui.fragments


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView

import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.adapters.CustomExpandableListAdapter
import com.mohsen.caculatebmi_mvvm.database.entity.Food
import com.mohsen.caculatebmi_mvvm.ui.dialogs.AddExerciseDialog
import com.mohsen.caculatebmi_mvvm.ui.dialogs.AddFoodDialog
import com.mohsen.caculatebmi_mvvm.ui.home.HomeActivity
import com.mohsen.caculatebmi_mvvm.util.EXTRA_FOOD
import com.mohsen.caculatebmi_mvvm.util.getExerciseData
import com.mohsen.caculatebmi_mvvm.util.getExpandableListData
import com.mohsen.caculatebmi_mvvm.util.toast
import kotlinx.android.synthetic.main.fragment_exercise.*
import kotlinx.android.synthetic.main.fragment_food_category.*
import java.util.HashMap

/**
 * A simple [Fragment] subclass.
 */
class ExerciseFragment(context: Context) : BaseFragment() {
    private var expandableListTitle: List<String>? = null
    private var expandableListDetail: HashMap<String, List<String>>? = null
    private var expandableListAdapter: ExpandableListAdapter? = null
    private var mContext = context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        expandableListDetail = getExerciseData()

       // expandableListDetail = getExpandableListData()
        expandableListTitle = ArrayList<String>((expandableListDetail as HashMap<String, MutableList<String>>?)!!.keys)
        expandableListAdapter =
            CustomExpandableListAdapter(context, expandableListTitle, expandableListDetail!!)
        exerciseExpandableListView.setAdapter(expandableListAdapter)

        exerciseExpandableListView.setOnChildClickListener(ExpandableListView.OnChildClickListener { parent, v, groupPosition, childPosition, id ->

            val title = (expandableListDetail as HashMap<String, MutableList<String>>?)!!.get(
                (expandableListTitle as ArrayList<String>).get(groupPosition)
            )!!.get(
                childPosition
            )
            val dialog = AddExerciseDialog(context!!,title)

            dialog.show()



            false
        })


    }


}
