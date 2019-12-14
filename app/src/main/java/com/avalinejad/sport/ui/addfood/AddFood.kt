package com.avalinejad.sport.ui.addfood

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.viewpager.widget.ViewPager
import com.avalinejad.sport.App
import com.avalinejad.sport.R
import com.avalinejad.sport.adapters.TabAdapter
import com.avalinejad.sport.ui.BaseActivity
import com.avalinejad.sport.ui.fragments.CategoryFragment
import com.avalinejad.sport.ui.fragments.ExerciseFragment
import kotlinx.android.synthetic.main.activity_add_food.*
import kotlinx.android.synthetic.main.app_bar.*

class AddFood : BaseActivity() {

    private var tabAdapter: TabAdapter? = null
    private val tabIcons = intArrayOf(
        R.drawable.ic_list,
        R.drawable.ic_running,
        R.drawable.ic_person_add_black_24dp
    )
    private val res = App.instance.resources
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)


        tabAdapter = TabAdapter(supportFragmentManager,this)


        tabAdapter?.addFragment(ExerciseFragment(this),res.getString(R.string.exercise_cat),tabIcons[1])
        tabAdapter?.addFragment(CategoryFragment(this),res.getString(R.string.food_cat),tabIcons[0])

        viewpager.adapter = tabAdapter
        calories_tab.setSelectedTabIndicatorColor(resources.getColor(R.color.bmi_below_18_5))
        calories_tab.setSelectedTabIndicatorHeight(5)

        calories_tab.setupWithViewPager(viewpager)


        if (intent.hasExtra("food_button")){
            Log.d("addfood","come from add food button")
//            tabAdapter?.addFragment(PersonalFoodFragment(),"غذاهای شخصی", tabIcons[2])
//            tabAdapter?.addFragment(FavouriteFoods(),"غذاهای مورد علاقه",tabIcons[1])

           // viewpager.setCurrentItem(0)
            //setTitle("اضافه کردن غذا")
            viewpager.currentItem = 1
            toolbar.title = res.getString(R.string.add_food)
            highLightCurrentTab(1)
        } else if (intent.hasExtra("exercise_button")){
            Log.d("addfood","come from add exercise button")
          //  viewpager.setCurrentItem(1)
           // setTitle("اضافه کردن غذا")
            toolbar.title = res.getString(R.string.add_exercise)
            viewpager.currentItem = 0
            highLightCurrentTab(0)

        } else {
            Log.d("addfood","came out of nowhere")
        }


//        viewpager.adapter = tabAdapter
//        calories_tab.setSelectedTabIndicatorColor(resources.getColor(R.color.bmi_below_18_5))
//        calories_tab.setSelectedTabIndicatorHeight(5)
//
//        calories_tab.setupWithViewPager(viewpager)
//        viewpager.setCurrentItem(0)

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                highLightCurrentTab(position)
                setFragmentTitle(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })


    }
    private fun setFragmentTitle(position: Int){
        if (position == 0){
            toolbar.title = res.getString(R.string.add_exercise)

//            viewpager.currentItem = 0
        }else{
            toolbar.title = res.getString(R.string.add_food)

        }
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)


    }
}
