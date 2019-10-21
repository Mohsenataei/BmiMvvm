package com.mohsen.caculatebmi_mvvm.database.dao

import androidx.room.*
import com.mohsen.caculatebmi_mvvm.database.entity.Detail
import com.mohsen.caculatebmi_mvvm.database.entity.Food

@Dao
interface DetailDao {
    @Query("SELECT * FROM ate_food_details")
    suspend fun getAll(): MutableList<Food>

    @Query("SELECT * FROM ate_food_details WHERE name LIKE :title")
    suspend fun findByTitle(title: String): Detail

//    @Query("SELECT * FROM food_items WHERE category LIKE :category")
//    fun findByCategory(category: String)

    @Insert
    suspend fun insertAll(vararg todo: Food)

    @Delete
    suspend fun delete(todo: Detail)

    @Update
    suspend fun updateTodo(vararg todos: Detail)
}