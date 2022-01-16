package com.maksapp.moviesearchapp.model

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [HistoryFilm::class], version = 1, exportSchema = false)
abstract class HistoryDataBase(): RoomDatabase() {

    abstract fun historyDAO():HistoryDAO


}