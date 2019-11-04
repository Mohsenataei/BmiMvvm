package com.avalinejad.sport.ui.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView

import com.avalinejad.sport.R
import com.avalinejad.sport.adapters.CustomExpandableListAdapter
import com.avalinejad.sport.ui.dialogs.AddExerciseDialog
import com.avalinejad.sport.util.getExerciseData
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.fragment_exercise.*
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

        //activity!!.toolbar.title = "انتخاب فعالیت ها"
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
