package com.maksapp.moviesearchapp.model

class RepositoryFilm: InterfaceRepository {
    override fun getDescriptionForFilm(): List<DescriptionFilm> {
        return getFilm()
    }

    override fun getFilmFromServer(): DescriptionFilm {
        TODO("Not yet implemented")
    }
}// тут будем получать данные