package com.maksapp.moviesearchapp.model

class RepositoryFilm: InterfaceRepository {
    override fun getDescriptionForFilm(): List<DescriptionFilm> {
        return getFilm()
    }

    override fun getFilmFromServer(): List<DescriptionDTO> {
        return getDesc()
    }
}// тут будем получать данные