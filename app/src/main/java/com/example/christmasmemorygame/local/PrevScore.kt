package com.example.christmasmemorygame.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

@Entity
data class PrevScore (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val score:Int
)