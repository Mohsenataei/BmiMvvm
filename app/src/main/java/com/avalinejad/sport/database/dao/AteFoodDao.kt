package com.avalinejad.sport.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.avalinejad.sport.database.entity.AteFood

@Dao
interface AteFoodDao {
    @Query("SELECT * FROM ate_foods_table")
    suspend fun getAll(): List<AteFood>

    @Query("SELECT * FROM ate_foods_table WHERE FoodID LIKE :title")
    suspend fun findByTitle(title: String): AteFood

    @Insert
    suspend fun insertAll(vararg todo: AteFood)

}