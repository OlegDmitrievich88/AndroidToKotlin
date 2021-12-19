package com.maksapp.moviesearchapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maksapp.moviesearchapp.model.DescriptionFilm
import com.maksapp.moviesearchapp.model.InterfaceRepository
import com.maksapp.moviesearchapp.model.RepositoryFilm
import java.lang.Exception
import kotlin.random.Random

class ViewModelFilm: ViewModel() {

    private val liveDataToObserver: MutableLiveData<AppState> = MutableLiveData()
    private val repositoryCinema: InterfaceRepository = RepositoryFilm()
    fun getData(): LiveData<AppState> = liveDataToObserver

    fun getDescriptionFilm() {
      //  liveDataToObserver.value = AppState.Loading
        liveDataToObserver.postValue(AppState.Success(repositoryCinema.getDescriptionForFilm()))
//        Thread{
//            Thread.sleep(2000)
//
//            if (Random.nextBoolean()){
////                val description: List<DescriptionFilm> = getFilm()
//                liveDataToObserver.postValue(AppState.Success(repositoryCinema.getDescriptionForFilm()))
//                  //  repositoryCinema.getDescriptionForFilm()
//
//            }else{
//                liveDataToObserver.postValue(AppState.Error(Exception("Что-то пошло не так")))
//            }
//
//        }.start()
    }
}