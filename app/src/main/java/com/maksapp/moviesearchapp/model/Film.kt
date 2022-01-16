package com.maksapp.moviesearchapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val imageFilm: Long, // изображение фильма
    val titleFilm: Int, //название фильма
    val descCinema: String,
    val nameCinema: String,
    val ratingCinema: String,
    val langCinema: String
):Parcelable
