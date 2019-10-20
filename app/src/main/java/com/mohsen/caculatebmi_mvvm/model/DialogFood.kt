package com.mohsen.caculatebmi_mvvm.model

import androidx.room.ColumnInfo
import java.io.Serializable

data class DialogFood(
    var name: String,
    var calory: String,
    var type: Int,
    var category: Int
) : Serializable