package com.mohsen.caculatebmi_mvvm.model

import java.io.Serializable

data class DialogFood(
    var name: String,
    var calory: String,
    var type: Int,
    var category: Int
) : Serializable