package com.avalinejad.sport.adapters

import android.content.Context
import android.database.DataSetObserver
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avalinejad.sport.R
import com.avalinejad.sport.util.favouriteFoods
import com.avalinejad.sport.util.toast




class CustomExpandableListAdapter(context: Context?, expandableListTitle: List<String>?, expandableListDetail: HashMap<String, List<String>>) :
    ExpandableListAdapter {
    var flags = Array(100) { Array(100) {false} }
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
        if (!flags[groupPosition][childPosition]){

          //  flags[groupPosition][childPosition] = true

            context!!.toast("baba laba dub dub")
            Log.d("FavBtn","flag[$groupPosition][$childPosition] is false")
//            favouriteFoods.add(expandedListText)
//            favBtn.setImageResource(R.drawable.ic_star_filled)
        }else{
          //  flags[groupPosition][childPosition] = false
            context!!.toast("ruby duby hub dub")
            Log.d("FavBtn","flag[$groupPosition][$childPosition] is true")
//            favouriteFoods.remove(expandedListText)
//            favBtn.setImageResource(R.drawable.ic_star_empty)
        }
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
            if (!flags[groupPosition][childPosition]){

                flags[groupPosition][childPosition] = true

                Log.d("FavBtn","flag[$groupPosition][$childPosition] is true now")
                context!!.toast("baba laba dub dub")
                favouriteFoods.add(expandedListText)
                favBtn.setImageResource(R.drawable.ic_star_filled)
            }else{
                flags[groupPosition][childPosition] = false
                context!!.toast("ruby duby hub dub")
                Log.d("FavBtn","flag[$groupPosition][$childPosition] is false again")
                favouriteFoods.remove(expandedListText)
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
        listTitleTextView.typeface = Typeface.createFromAsset(context!!.applicationContext.assets,"fonts/iran_sans_normal.ttf")
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
