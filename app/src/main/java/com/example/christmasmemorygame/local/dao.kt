package com.example.christmasmemorygame.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface dao {

    @Query("SELECT * FROM prevscore")
    fun getPrevScores():LiveData<List<PrevScore>>

    @Insert
    suspend fun insert(prevScore: PrevScore)
}