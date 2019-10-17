package com.mohsen.caculatebmi_mvvm.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_items")
data class Food (
    @PrimaryKey(autoGenerate = true)

    var id: Int,

    @ColumnInfo(name = "food_name") var food_name: String,
    @ColumnInfo(name = "calory") var calory: Int,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "category") var category: String
)