package com.maksapp.moviesearchapp.model

interface LocalRepository {

   // fun getAllHistory(): List<FactDescriptionDTO>

    fun saveFilm(film: FactDescriptionDTO)

}