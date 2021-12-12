package com.maksapp.moviesearchapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maksapp.moviesearchapp.model.DescriptionFilm
import com.maksapp.moviesearchapp.model.Film
import java.lang.Exception
import kotlin.random.Random

class ViewModelFilm: ViewModel() {

    private val liveDataToObserver: MutableLiveData<AppState> = MutableLiveData()

    fun getData(): LiveData<AppState> = liveDataToObserver

    fun getDescriptionFilm() {
        liveDataToObserver.value = AppState.Loading

        Thread{
            Thread.sleep(2000)

            if (Random.nextBoolean()){
                val description = DescriptionFilm("Good cinema, very good")
                liveDataToObserver.postValue(AppState.Success(description))
            }else{
                liveDataToObserver.postValue(AppState.Error(Exception("Что-то пошло не так")))
            }

        }.start()
    }
}