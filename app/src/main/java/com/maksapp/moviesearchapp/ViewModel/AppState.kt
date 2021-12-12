package com.maksapp.moviesearchapp.ViewModel

import com.maksapp.moviesearchapp.model.DescriptionFilm
import com.maksapp.moviesearchapp.model.Film

sealed class AppState{
    data class Success(val descriptionFilm: DescriptionFilm): AppState()
    data class Error(val error: Throwable): AppState()
    object Loading: AppState()
}
