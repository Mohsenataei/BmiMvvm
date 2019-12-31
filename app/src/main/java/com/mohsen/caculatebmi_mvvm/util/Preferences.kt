package com.mohsen.caculatebmi_mvvm.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder
import com.mohsen.caculatebmi_mvvm.database.entity.Food
import com.google.gson.reflect.TypeToken
import com.mohsen.caculatebmi_mvvm.model.Exercise
import kotlin.properties.Delegates


class Preferences(context: Context) {
    val context: Context = context.applicationContext
    val gson by lazy { GsonBuilder().create() }
    val foodPreferences by lazy {
        context.getSharedPreferences(
            "FoodPreference",
            Context.MODE_PRIVATE
        )
    }
    val exercusePrefrences by lazy {
        context.getSharedPreferences(
            "ExercisePreferences",
            Context.MODE_PRIVATE
        )
    }



    fun saveFood(food: Food, date: String = today_Date) {
        saveAllFoods(loadAllFoods(date).apply {
            val index = indexOf(food)
            if (index >= 0)
                set(index, food)
            else
                add(food)
        })
    }


    fun saveExercise(exercise: Exercise, date: String= today_Date){
        saveAllExercises((loadAllExercises(date).apply {
            val index = indexOf(exercise)
            if (index >= 0)
                set(index, exercise)
            else
                add(exercise)
        }))
    }




    fun removeFood(food: Food, date: String = today_Date) {
        saveAllFoods(loadAllFoods(date).apply { remove(food) })
    }



    fun removeExercise(exercise: Exercise, date: String = today_Date) {
        saveAllExercises(loadAllExercises(date).apply { remove(exercise) })
    }


    fun loadAllFoods(date: String = today_Date) = foodPreferences.getString(date, "[]").let {
        val listType = object : TypeToken<ArrayList<Food>>() {

        }.type
        gson.fromJson<List<Food>>(it, listType).toMutableList()
    }

    fun loadAllExercises(date: String= today_Date) = exercusePrefrences.getString(date,"[]").let{
     val listType = object : TypeToken<ArrayList<Exercise>>(){

     }.type
        gson.fromJson<List<Exercise>>(it,listType).toMutableList()
    }

   private fun saveAllFoods(list: List<Food>, date: String = today_Date) =
        foodPreferences.edit().putString(date, gson.toJson(list)).apply()

    private fun saveAllExercises(list: List<Exercise>, date: String= today_Date) =
        exercusePrefrences.edit().putString(date, gson.toJson(list)).apply()



    companion object {
        @SuppressLint("StaticFieldLeak")
        private var instance: Preferences? = null

        fun getInstance(context: Context): Preferences {
            if (instance == null)
                instance = Preferences(context)
            return instance!!
        }
    }
}