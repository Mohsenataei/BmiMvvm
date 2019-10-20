package com.mohsen.caculatebmi_mvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mohsen.caculatebmi_mvvm.database.dao.AteFoodDao
import com.mohsen.caculatebmi_mvvm.database.dao.FoodDao
import com.mohsen.caculatebmi_mvvm.database.entity.AteFood
import com.mohsen.caculatebmi_mvvm.database.entity.Food

@Database(entities = arrayOf(Food::class, AteFood::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
    abstract fun addedFoodDao(): AteFoodDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {
            if (INSTANCE == null){
                synchronized(AppDatabase::class.java){
                    if (INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java,
                            "appDAtabase").createFromAsset("db/BMICalory.db")
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