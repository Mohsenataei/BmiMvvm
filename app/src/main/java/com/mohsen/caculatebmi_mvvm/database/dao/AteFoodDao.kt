package com.mohsen.caculatebmi_mvvm.database.dao

import androidx.room.*
import com.mohsen.caculatebmi_mvvm.database.entity.AteFood

@Dao
interface AteFoodDao {
    @Query("select * from Added_Foods")
    suspend fun getAll(): List<AteFood>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg todo: AteFood)

    @Delete
    suspend fun delete(todo: AteFood)

    @Update
    suspend fun updateTodo(vararg todos: AteFood)
}