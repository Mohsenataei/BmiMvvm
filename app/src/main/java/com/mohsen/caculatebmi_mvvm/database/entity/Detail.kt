package com.mohsen.caculatebmi_mvvm.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ate_food_details")
data class Detail(
    @PrimaryKey(autoGenerate = true)

    var ID: Int,

    @ColumnInfo(name = "unit") var unit: Int,
    @ColumnInfo(name = "name") var nmae: String,
    @ColumnInfo(name = "calory") var calory: Int,
    @ColumnInfo(name = "category") var category: String
)

