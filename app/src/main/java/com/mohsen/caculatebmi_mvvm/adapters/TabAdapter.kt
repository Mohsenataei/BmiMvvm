package com.mohsen.caculatebmi_mvvm.adapters

import android.content.Context
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.mohsen.caculatebmi_mvvm.R
import java.util.ArrayList

class TabAdapter(fragmentManager: FragmentManager, context: Context) : FragmentStatePagerAdapter(fragmentManager) {

    private val mFragment :  MutableList<Fragment> = ArrayList()
    private val mFragmentIconList : MutableList<Int> = ArrayList()
    private val mFragmentTitleList : MutableList<String> = ArrayList()
    private val context = context

    override fun getItem(position: Int): Fragment {
        return mFragment[position]
    }

    override fun getCount(): Int {
        return mFragment.size
    }

    fun addFragment(fragment: Fragment, title: String, tabIcon: Int){
        mFragment.add(fragment)
        mFragmentTitleList.add(title)
        mFragmentIconList.add(tabIcon)
    }

    fun getTabView(pos: Int) : View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.tab_layout,null,false)
        val textView = view.findViewById<TextView>(R.id.tabTextView) as TextView
        val imageView = view.findViewById<ImageView>(R.id.tabImageView) as ImageView

        textView.text = mFragmentTitleList.get(pos)
        imageView.setImageResource(mFragmentIconList[pos])

        return view
    }

    fun getSelectedTabView(pos: Int) : View {

        val view = LayoutInflater.from(context).inflate(R.layout.tab_layout, null,false)
        val tabTextView = view.findViewById<TextView>(R.id.tabTextView)
        tabTextView.setText(mFragmentTitleList[pos])
        tabTextView.setTextColor(ContextCompat.getColor(context, R.color.color_tab))
        val tabImageView = view.findViewById<ImageView>(R.id.tabImageView)
        tabImageView.setImageResource(mFragmentIconList[pos])
        tabImageView.setColorFilter(
            ContextCompat.getColor(context, R.color.color_tab),
            PorterDuff.Mode.SRC_ATOP
        )
        return view
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }
}