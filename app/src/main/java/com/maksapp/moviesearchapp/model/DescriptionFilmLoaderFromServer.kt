package com.maksapp.moviesearchapp.model

import android.os.Build
import android.os.Handler
import android.os.Looper
import com.google.gson.Gson
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection
import kotlin.Exception

object DescriptionFilmLoaderFromServer {

    private const val API_KEY = "3ec60504f353a51aa5d8f9dc40c25f91"

    fun loadOkhttp(listener: InterfaceLoaderDescription){

        val client: OkHttpClient = OkHttpClient.Builder()
            .callTimeout(1000,TimeUnit.MILLISECONDS)
            .connectTimeout(1000,TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
            .build()

        val build: Request = Request.Builder()
            .get()
            //.addHeader("api_key", API_KEY)
            .url("https://api.themoviedb.org/3/movie/popular?api_key=3ec60504f353a51aa5d8f9dc40c25f91")
            .build()

        client.newCall(build).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                listener.onFailed(e)
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful){
                val descDto = Gson().fromJson(response.body?.string(), FactDescriptionDTO::class.java)
                listener.onLoad(descDto)
                }else{
                    listener.onFailed(Exception(response.body?.string()))
                }
            }
        })
    }

    fun loadDescription(listener: InterfaceLoaderDescription) {
        val  handler = Handler(Looper.myLooper() ?: Looper.getMainLooper())
        Thread{
            var urlConnection: HttpsURLConnection? = null

            try {
                val uri = URL("https://api.themoviedb.org/3/movie/popular?api_key=3ec60504f353a51aa5d8f9dc40c25f91")
                urlConnection = uri.openConnection() as HttpsURLConnection
               // urlConnection.addRequestProperty("api_key", API_KEY)
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