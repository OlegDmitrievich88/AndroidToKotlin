package com.maksapp.moviesearchapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maksapp.moviesearchapp.model.*

class ViewModelFilm: ViewModel() {

    private val liveDataToObserver: MutableLiveData<AppState> = MutableLiveData()
    private val repositoryCinema: InterfaceRepository = RepositoryFilm()
    fun getData(): LiveData<AppState> = liveDataToObserver

    fun getDescriptionFilm() {
      //  liveDataToObserver.value = AppState.Loading
       // liveDataToObserver.postValue(AppState.Success(repositoryCinema.getDescriptionForFilm()))
       DescriptionFilmLoaderFromServer.loadDescription(object : InterfaceLoaderDescription {
           override fun onLoad(descDTO: FactDescriptionDTO) {
               TODO("Not yet implemented")
           }

           override fun onFailed(throwable: Throwable) {
               TODO("Not yet implemented")
           }
       } )
        liveDataToObserver.postValue(AppState.Success(repositoryCinema.getFilmFromServer()))
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