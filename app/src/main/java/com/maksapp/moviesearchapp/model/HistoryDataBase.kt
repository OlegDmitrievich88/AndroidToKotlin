package com.maksapp.moviesearchapp.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HistoryFilm::class], version = 1, exportSchema = false)
abstract class HistoryDataBase : RoomDatabase() {

    abstract fun historyDAO():HistoryDAO


}