package com.maksapp.moviesearchapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryFilm(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nameFilm: String,
    val lang: String,
    val rating: String,
    val content: String,
   // val dataTime: Long
)
