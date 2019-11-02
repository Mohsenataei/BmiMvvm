package com.avalinejad.sport.util


import com.alirezaafkar.sundatepicker.components.DateItem
import java.util.*


internal class Date : DateItem() {
    val date: String
        get() {
            val calendar = calendar
            return String.format(
                Locale.US,
                "%d/%d/%d",
                year, month, day,
                calendar.get(Calendar.YEAR),
                +calendar.get(Calendar.MONTH) + 1,
                +calendar.get(Calendar.DAY_OF_MONTH)
            )
        }
}