package com.maksapp.moviesearchapp.model

import android.app.IntentService
import android.content.Intent
import android.content.Context


class LoadService : IntentService("LoadService") {

    override fun onHandleIntent(intent: Intent?) {
        intent?.getParcelableExtra<DescriptionDTO>("Description")?.let {
            DescriptionFilmLoaderFromServer.loadDescription(object: InterfaceLoaderDescription{
                override fun onLoad(descDTO: FactDescriptionDTO) {
                    TODO("Not yet implemented")
                }

                override fun onFailed(throwable: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}