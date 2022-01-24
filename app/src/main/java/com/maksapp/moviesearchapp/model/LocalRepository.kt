package com.maksapp.moviesearchapp.model

interface LocalRepository {

    fun getAllHistory(): List<HistoryFilm>

    fun saveFilm(film: FactDescriptionDTO)

}