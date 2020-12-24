package com.example.christmasmemorygame.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [PrevScore::class], version = 2, exportSchema = false)
abstract class ScoreDatabase : RoomDatabase() {

    abstract fun getDao(): dao

    companion object {
        @Volatile
        private var instance: ScoreDatabase? = null

        @InternalCoroutinesApi
        fun getInstance(context: Context): ScoreDatabase {

            if (instance == null) {
                instance = Room.databaseBuilder(context, ScoreDatabase::class.java, "my_db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance as ScoreDatabase

        }
    }
}