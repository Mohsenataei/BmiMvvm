package com.avalinejad.sport.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.avalinejad.sport.database.dao.AteFoodDao
import com.avalinejad.sport.database.dao.DetailDao
import com.avalinejad.sport.database.dao.FoodDao
import com.avalinejad.sport.database.entity.AteFood
import com.avalinejad.sport.database.entity.Detail
import com.avalinejad.sport.database.entity.Food



@Database(entities = arrayOf(Food::class,AteFood::class, Detail::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
    abstract fun ateFoodDao(): AteFoodDao
   // abstract fun selectFoodDao(): SelectedFoodDao
    abstract fun detailDao(): DetailDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {
            if (INSTANCE == null){
                synchronized(AppDatabase::class.java){
                    if (INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java,
                            "appDAtabase").createFromAsset("database/CaloriesDatabase")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }


}