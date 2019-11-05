package com.avalinejad.sport.adapters

import android.content.Context
import android.database.DataSetObserver
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avalinejad.sport.R
import com.avalinejad.sport.util.toast




class CustomExpandableListAdapter(context: Context?, expandableListTitle: List<String>?, expandableListDetail: HashMap<String, List<String>>) :
    ExpandableListAdapter {
    override fun registerDataSetObserver(observer: DataSetObserver?) {

    }

    private val titles = expandableListTitle
    val context = context
    private val listDetails = expandableListDetail


    override fun onGroupCollapsed(groupPosition: Int) {

    }

    override fun isEmpty(): Boolean {
        return false
    }

    override fun onGroupExpanded(groupPosition: Int) {

    }

    override fun getCombinedChildId(groupId: Long, childId: Long): Long {
        return  childId
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        val selectedPosition = -1
        val selectedPosition_parent = -1
        var flag = false
        var convertView = convertView
        val expandedListText = getChild(groupPosition, childPosition) as String
        if (convertView == null) {
            val layoutInflater = this.context!!
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.list_item, null)
        }
        val expandedListTextView = convertView!!
            .findViewById<View>(R.id.expandedListItem) as TextView
        val favBtn = convertView.findViewById<View>(R.id.expandedListFavBtn) as ImageView
        expandedListTextView.text = expandedListText

        favBtn.setOnClickListener {
            if (!flag){
                flag = !flag

                context!!.toast("baba laba dub dub")
                favBtn.setImageResource(R.drawable.ic_star_filled)
            }else{
                flag = !flag
                context!!.toast("ruby duby hub dub")
                favBtn.setImageResource(R.drawable.ic_star_empty)
            }
        }


//        convertView.findViewById<ImageView>(R.id.expandedListFavBtn).setOnClickListener {
//            if (!flag){
//                flag = true
//                context!!.toast("baba laba dub dub")
//                convertView.findViewById<ImageView>(R.id.expandedListFavBtn).setImageResource(R.drawable.ic_star_filled)
//            } else {
//                flag = false
//                context!!.toast("ruby duby hub dub")
//                convertView.findViewById<ImageView>(R.id.expandedListFavBtn).setImageResource(R.drawable.ic_star_empty)
//            }
//        }
        return convertView
    }


    override fun areAllItemsEnabled(): Boolean {
        return false
    }

    override fun getCombinedGroupId(groupId: Long): Long {
        return groupId
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        val listTitle = getGroup(groupPosition) as String
        var convertView = convertView
        if (convertView == null) {
            val layoutInflater =
                this.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.list_group, null)
        }
        val listTitleTextView = convertView!!
            .findViewById<View>(R.id.listTitle) as TextView
        listTitleTextView.setTypeface(null, Typeface.BOLD)
        listTitleTextView.text = listTitle
        return convertView
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {

    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return listDetails.get(titles?.get(groupPosition))!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return this.titles!!.get(groupPosition)
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String? {
        return this.listDetails.get(this.titles?.get(groupPosition))?.get(childPosition)
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
            return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return titles!!.size
    }

    fun filterData(query: String){
        val lowerCaseQuery = query.toLowerCase()

    }




}
