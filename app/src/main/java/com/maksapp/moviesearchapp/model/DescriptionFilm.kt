package com.maksapp.moviesearchapp.model

import android.os.Parcelable
import com.maksapp.moviesearchapp.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DescriptionFilm(
    val film: Film = getDefaultFilm(),
    val poster: Int,
    val description: String,
    val rating: String,
    val reviews: String
): Parcelable

fun getDefaultFilm(): Film {
return getDefaultFilm()
}


fun getFilm(): List<DescriptionFilm> {
    return listOf(
        DescriptionFilm(Film(R.drawable.ebrg,"EkatFilm"),0,"EkatFil very good cinema","",""),
        DescriptionFilm(Film(R.drawable.msc,"MoscowFilm"),1,"MoscowFilm very good cinema","",""),
        DescriptionFilm(Film(R.drawable.nsk,"NskFilm"),2,"NskFilm very good cinema","",""),
        DescriptionFilm(Film(R.drawable.sam,"SamFilm"),3,"SamFilm very good cinema","",""),
        DescriptionFilm(Film(R.drawable.spb,"SpbFilm"),4,"SpbFilm very good cinema","",""),
        DescriptionFilm(Film(R.drawable.ebrg,"EkatFilmTwo"),5,"EkatFilmTwo very good cinema","","")
    )
}

