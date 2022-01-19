package com.maksapp.moviesearchapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class DescriptionDTO(
    val descDTO:  FactDescriptionDTO,
//    val descCinema: String,
//    val nameCinema: String,
//    val ratingCinema: String,
//    val langCinema: String
): Parcelable

fun getDesc():List<DescriptionDTO> {return listOf()}