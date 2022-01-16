package com.maksapp.moviesearchapp.model

interface LocalRepository {

    fun getAllHistory(): List<DescriptionDTO>

    fun saveFilm(film: DescriptionDTO)
}