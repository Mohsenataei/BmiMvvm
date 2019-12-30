package com.mohsen.caculatebmi_mvvm.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohsen.caculatebmi_mvvm.R


/**
 * A simple [Fragment] subclass.
 */
class FragmentFavFoods : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav_food, container, false)
    }



}
