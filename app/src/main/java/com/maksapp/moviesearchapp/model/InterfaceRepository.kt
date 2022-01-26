package com.maksapp.moviesearchapp.model

interface InterfaceRepository {
    fun getDescriptionForFilm(): List<DescriptionFilm>
    fun getFilmFromServer():List<DescriptionDTO>
} //интерфейс для взаимодействия с репозиторием