package com.maksapp.moviesearchapp.model

class RepositoryFilm: InterfaceRepository {
    override fun getDescriptionForFilm(): Film {
        return Film(1, "matrix")
    }
}