package com.maksapp.moviesearchapp.model

import java.util.*

class LocalRepositoryIml(private val dao: HistoryDAO):LocalRepository{

    override fun getAllHistory(): List<HistoryFilm> {
        return dao.all()

    }



    override fun saveFilm(film: FactDescriptionDTO) {
        dao.insert(
            HistoryFilm(
                id = 0,
                nameFilm = film.title,
                lang = film.original_language,
                rating = film.popularity,
                content = film.overview,
                dataTime = Date().time
            )
        )
    }
}