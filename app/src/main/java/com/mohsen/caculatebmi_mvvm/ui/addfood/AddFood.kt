package com.mohsen.caculatebmi_mvvm.ui.addfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.adapters.TabAdapter

class AddFood : AppCompatActivity() {

    private val tabAdapter: TabAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)




    }
}
