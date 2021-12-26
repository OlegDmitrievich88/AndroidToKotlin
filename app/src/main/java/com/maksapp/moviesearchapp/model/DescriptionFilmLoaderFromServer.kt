package com.maksapp.moviesearchapp.model

import android.os.Build
import android.os.Handler
import android.os.Looper
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

object DescriptionFilmLoaderFromServer {

    private const val API_KEY = "3ec60504f353a51aa5d8f9dc40c25f91"

    fun loadDescription(listener: InterfaceLoaderDescription) {
        val  handler = Handler(Looper.myLooper() ?: Looper.getMainLooper())
        Thread{
            var urlConnection: HttpsURLConnection? = null

            try {
                val uri = URL("https://api.themoviedb.org/3/movie/popular?api_key=3ec60504f353a51aa5d8f9dc40c25f91&year=2021")
                urlConnection = uri.openConnection() as HttpsURLConnection
                urlConnection.addRequestProperty("themoviedb_api_key", API_KEY)
                urlConnection.requestMethod = "GET"
                urlConnection.readTimeout = 1000
                urlConnection.connectTimeout = 1000
                val  reader = BufferedReader(InputStreamReader(urlConnection.inputStream))
                val result = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    reader.lines().collect(Collectors.joining("\n"))
                }else{""}

                val descDto = Gson().fromJson(result, FactDescriptionDTO::class.java)
               handler.post {
                   listener.onLoad(descDto)
               }
            }catch(e:Exception) {
                listener.onFailed(e)
            }finally {
                urlConnection?.disconnect()
            }
        }.start()
    }
}