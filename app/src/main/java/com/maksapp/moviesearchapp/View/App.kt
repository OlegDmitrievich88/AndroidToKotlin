package com.maksapp.moviesearchapp.View

import android.app.Application
import androidx.room.Room.databaseBuilder
import com.maksapp.moviesearchapp.model.HistoryDAO
import com.maksapp.moviesearchapp.model.HistoryDataBase


class App: Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }


    companion object {

        private var appInstance: App? = null
        private var db: HistoryDataBase? = null
        private const val DB_NAME = "History.db"


        fun getHistoryDao(): HistoryDAO {

            if (db == null) {

            synchronized(HistoryDataBase::class.java){
                    if (db == null){
                        appInstance?.let { app->
                            db = databaseBuilder(
                               app.applicationContext,
                               HistoryDataBase::class.java,
                               DB_NAME
                            ).allowMainThreadQueries()
                                .build()
                        }?: throw Exception("WTF")
                    }
                }
            }
            return db!!.historyDAO()
        }
    }
}