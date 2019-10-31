package com.avalinejad.sport.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ate_foods_table")
data class AteFood(
    @PrimaryKey(autoGenerate = true)
    var ID: Int,
    @ColumnInfo(name= "FoodID") var FoodID: Int
)