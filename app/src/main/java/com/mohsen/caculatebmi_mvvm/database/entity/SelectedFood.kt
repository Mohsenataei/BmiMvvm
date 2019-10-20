package com.mohsen.caculatebmi_mvvm.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "ate_foods_table",foreignKeys = arrayOf(ForeignKey(entity = Food::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("foodId"),
        onDelete = ForeignKey.CASCADE)) )

data class SelectedFood(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var foodId: Int
)