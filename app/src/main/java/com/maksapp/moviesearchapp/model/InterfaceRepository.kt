package com.maksapp.moviesearchapp.model

interface InterfaceRepository {
    fun getDescriptionForFilm(): List<DescriptionFilm>
    fun getFilmFromServer():DescriptionFilm
} //интерфейс для взаимодействия с репозиторием