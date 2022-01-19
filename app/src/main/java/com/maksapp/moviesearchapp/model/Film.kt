package com.maksapp.moviesearchapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val imageFilm: Int, // изображение фильма
    val titleFilm: String, //название фильма
//    val descCinema: String,
//    val nameCinema: String,
//    val ratingCinema: String,
//    val langCinema: String
):Parcelable
