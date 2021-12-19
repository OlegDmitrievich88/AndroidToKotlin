package com.maksapp.moviesearchapp.ViewModel

import com.maksapp.moviesearchapp.model.DescriptionFilm

sealed class AppState{
    data class Success(val cinema: List<DescriptionFilm>) : AppState()
    data class Error(val error: Throwable): AppState()
    object Loading: AppState()
}
