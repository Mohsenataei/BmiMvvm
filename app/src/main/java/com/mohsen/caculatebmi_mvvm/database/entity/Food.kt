package com.mohsen.caculatebmi_mvvm.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "food_table")
data class Food  (
    @PrimaryKey(autoGenerate = true)
    var ID: Int,
    @ColumnInfo(name = "unit") var unit: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "calory") var calory: Int,
    @ColumnInfo(name = "category") var category: String
) : Serializable