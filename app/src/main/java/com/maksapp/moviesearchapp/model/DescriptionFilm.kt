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
        DescriptionFilm(Film(R.drawable.ebrg,"zdgdsg"),0,"","",""),
        DescriptionFilm(Film(R.drawable.ebrg,"dsgds"),1,"","",""),
        DescriptionFilm(Film(R.drawable.ebrg,"sdgdsg"),2,"","",""),
        DescriptionFilm(Film(R.drawable.ebrg,"dsgdsfgds"),3,"","",""),
        DescriptionFilm(Film(R.drawable.ebrg,"sdgdszg"),4,"","",""),
        DescriptionFilm(Film(R.drawable.ebrg,"gdsgzsd"),5,"","","")
    )
}

