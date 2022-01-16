package com.maksapp.moviesearchapp.model

class LocalRepositoryIml (private val  dao: HistoryDAO):LocalRepository{

    override fun getAllHistory(): List<DescriptionDTO> {
        return dao.all()
            .map { historyFilm ->
                DescriptionDTO(

                    nameCinema = historyFilm.nameFilm,
                    ratingCinema = historyFilm.rating,
                    descCinema = historyFilm.content,
                    langCinema = historyFilm.lang

            )

            }
    }



    override fun saveFilm(film: DescriptionDTO) {
        dao.insert(
            HistoryFilm(
                id = 0,
                nameFilm = film.nameCinema,
                lang = film.langCinema,
                rating = film.ratingCinema,
                content = film.descCinema
            )
        )
    }
}