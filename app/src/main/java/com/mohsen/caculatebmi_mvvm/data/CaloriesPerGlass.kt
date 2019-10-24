package com.mohsen.caculatebmi_mvvm.data

class CaloriesPerGlass {

    fun getPerGlassCalories(): java.util.HashMap<String,Int> {
        val perGramCalories = HashMap<String, Int>()

        perGramCalories.put("آلبالو با هسته یک لیوان",60)
        perGramCalories.put("آناناس ( کنسرو در شربت )",200)

        return  perGramCalories
    }
}