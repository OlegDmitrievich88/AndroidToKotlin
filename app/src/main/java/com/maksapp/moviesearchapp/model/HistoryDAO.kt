package com.maksapp.moviesearchapp.model

import androidx.room.*

@Dao
interface HistoryDAO {

    @Query("SELECT * FROM HistoryFilm ORDER BY dataTime DESC")
    fun all(): List<HistoryFilm>

    @Query("SELECT * FROM HistoryFilm WHERE (nameFilm LIKE :film) ORDER BY dataTime DESC")
    fun getHistoryFilm(film: String): List<HistoryFilm>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(film: HistoryFilm)

    @Update
    fun update(film: HistoryFilm)

    @Delete
    fun delete(film: HistoryFilm)
}