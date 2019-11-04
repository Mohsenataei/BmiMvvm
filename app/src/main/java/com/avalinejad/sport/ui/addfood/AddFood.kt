package com.avalinejad.sport.ui.addfood

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.avalinejad.sport.R
import com.avalinejad.sport.adapters.TabAdapter
import com.avalinejad.sport.ui.BaseActivity
import com.avalinejad.sport.ui.fragments.CategoryFragment
import com.avalinejad.sport.ui.fragments.ExerciseFragment
import com.avalinejad.sport.ui.fragments.FavouriteFoods
import com.avalinejad.sport.ui.fragments.PersonalFoodFragment
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_add_food.*
import kotlinx.android.synthetic.main.app_bar.*

class AddFood : BaseActivity() {

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

        tabAdapter?.addFragment(CategoryFragment(this),"دسته بندی غذاها",tabIcons[0])
        tabAdapter?.addFragment(ExerciseFragment(this),"اضافه کردن ورزش",tabIcons[1])


        if (intent.hasExtra("food_button")){
            Log.d("addfood","come from add food button")
//            tabAdapter?.addFragment(PersonalFoodFragment(),"غذاهای شخصی", tabIcons[2])
//            tabAdapter?.addFragment(FavouriteFoods(),"غذاهای مورد علاقه",tabIcons[1])

            viewpager.setCurrentItem(0)
            setTitle("اضافه کردن غذا")
            toolbar.title = "اضافه کردن غذا"
        } else if (intent.hasExtra("exercise_button")){
            Log.d("addfood","come from add exercise button")
            viewpager.setCurrentItem(1)
            setTitle("اضافه کردن غذا")
            toolbar.title = "اضافه کردن فعالیت ورزشی"

        } else {
            Log.d("addfood","came out of nowhere")
        }


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
