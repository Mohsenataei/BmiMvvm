package com.avalinejad.sport.database.entity

import androidx.room.*
import com.avalinejad.sport.util.DateConvertor
import java.util.*


@Entity(tableName = "ate_food_details")
@TypeConverters(DateConvertor::class)
data class Detail(
    @PrimaryKey(autoGenerate = true)
    var ID: Int,
    @ColumnInfo(name = "unit") var unit: Int,
    @ColumnInfo(name = "name") var nmae: String,
    @ColumnInfo(name = "calory") var calory: Int,
    @ColumnInfo(name = "category") var category: String
   // @ColumnInfo(name = "date") var date: Date

)

