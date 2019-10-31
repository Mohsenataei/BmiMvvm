package com.avalinejad.sport.database.dao

import androidx.room.*
import com.avalinejad.sport.database.entity.Food

@Dao
interface FoodDao {
    @Query("select * from food_table")
    abstract suspend fun getAll(): List<Food>

    @Query("SELECT * FROM food_table WHERE name LIKE :title")
    suspend fun findByTitle(title: String): Food

//    @Query("SELECT * FROM food_items WHERE category LIKE :category")
//    fun findByCategory(category: String)

    @Insert
    suspend fun insertAll(vararg todo: Food)

    @Delete
    suspend fun delete(todo: Food)

    @Update
    suspend fun updateTodo(vararg todos: Food)

}
// ID=Column{name='ID', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=1, defaultValue='null'}, category=Column{name='category', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='null'}}, foreignKeys=[], indices=[]}
// ID=Column{name='ID', type='INTEGER', affinity='3', notNull=false, primaryKeyPosition=1, defaultValue='null'}, , category=Column{name='category', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='null'}}, foreignKeys=[], indices=[]}

