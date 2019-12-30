package com.mohsen.caculatebmi_mvvm.util

import androidx.room.TypeConverter
import java.util.Date

open class DateConvertor {

    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return if (dateLong == null) null else Date(dateLong)
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }
}