package com.maksapp.moviesearchapp.model

interface InterfaceLoaderDescription {
    fun onLoad(descDTO: FactDescriptionDTO)
    fun onFailed(throwable: Throwable)
}