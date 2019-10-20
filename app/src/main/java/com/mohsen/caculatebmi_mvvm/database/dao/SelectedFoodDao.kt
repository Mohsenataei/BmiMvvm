package com.mohsen.caculatebmi_mvvm.database.dao

import androidx.room.*
import com.mohsen.caculatebmi_mvvm.database.entity.Food
import com.mohsen.caculatebmi_mvvm.database.entity.SelectedFood

@Dao
interface SelectedFoodDao {
    @Query("select * from ate_foods_table")
    suspend fun getAll(): List<SelectedFood>

    @Query("SELECT * FROM food_items WHERE food_name LIKE :title")
    suspend fun findByTitle(title: String): SelectedFood

//    @Query("SELECT * FROM food_items WHERE category LIKE :category")
//    fun findByCategory(category: String)

    @Insert
    suspend fun insertAll(vararg todo: SelectedFood)

    @Delete
    suspend fun delete(todo: SelectedFood)

    @Update
    suspend fun updateTodo(vararg todos: SelectedFood)
}