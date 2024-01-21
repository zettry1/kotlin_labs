package com.example.miu_mobile_assignemnt.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = [PlantModel::class], version = 1, exportSchema = false)
abstract class MyDataBase : RoomDatabase() {
    abstract fun dbDao(): DBDao

    companion object {
        @Volatile
        private var INSTANCE: MyDataBase? = null
        fun getMyDataBase(context: Context): MyDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, MyDataBase::class.java, "orgil_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}