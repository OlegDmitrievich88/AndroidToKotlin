package com.maksapp.moviesearchapp.ViewModel

import com.maksapp.moviesearchapp.model.DescriptionDTO
import com.maksapp.moviesearchapp.model.FactDescriptionDTO

sealed class AppState{
    data class SuccessTwo(val cinemaTwo: List<DescriptionDTO>) : AppState()
    data class Success(val cinema: FactDescriptionDTO) : AppState()
    data class Error(val error: Throwable): AppState()
    object Loading: AppState()
}
