package com.mohsen.caculatebmi_mvvm.ui.addfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.adapters.TabAdapter
import com.mohsen.caculatebmi_mvvm.ui.fragments.CategoryFragment
import com.mohsen.caculatebmi_mvvm.ui.fragments.FavouriteFoods
import com.mohsen.caculatebmi_mvvm.ui.fragments.PersonalFoodFragment
import kotlinx.android.synthetic.main.activity_add_food.*

class AddFood : AppCompatActivity() {

    private var tabAdapter: TabAdapter? = null
    private val tabIcons = intArrayOf(
        R.drawable.ic_add_black_24dp,
        R.drawable.ic_star_border_black_24dp,
        R.drawable.ic_person_add_black_24dp
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        tabAdapter = TabAdapter(supportFragmentManager,this)

        tabAdapter?.addFragment(PersonalFoodFragment(),"غذاهای شخصی", tabIcons[2])
        tabAdapter?.addFragment(FavouriteFoods(),"غذاهای مورد علاقه",tabIcons[1])
        tabAdapter?.addFragment(CategoryFragment(this),"دسته بندی غذاها",tabIcons[0])

        viewpager.adapter = tabAdapter
        calories_tab.setSelectedTabIndicatorColor(resources.getColor(R.color.bmi_below_18_5))
        calories_tab.setSelectedTabIndicatorHeight(5)

        calories_tab.setupWithViewPager(viewpager)
        viewpager.setCurrentItem(2)
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                highLightCurrentTab(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })


    }
    private fun highLightCurrentTab(position: Int) {
        for (i in 0 until calories_tab.getTabCount()) {
            val tab = calories_tab.getTabAt(i)!!
            tab!!.setCustomView(null)
            tab!!.setCustomView(tabAdapter?.getTabView(i))
        }
        val tab = calories_tab.getTabAt(position)!!
        tab!!.setCustomView(null)
        tab!!.setCustomView(tabAdapter?.getSelectedTabView(position))
    }
}
