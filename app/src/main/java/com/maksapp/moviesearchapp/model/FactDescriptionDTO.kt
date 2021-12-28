package com.maksapp.moviesearchapp.model

data class FactDescriptionDTO(
    val results: List<FactDescriptionDTO>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
   // val vote_average: Int,
    val vote_count: Int,

)
