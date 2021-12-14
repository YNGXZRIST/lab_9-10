package ru.kulagin.lab9_10.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.kulagin.lab9_10.data.network.services.CakesService
import ru.kulagin.lab9_10.data.network.services.CakesServiceApi

internal object AppNetwork {
    private val gson = GsonBuilder().create()

    private val okHttpClient= OkHttpClient().newBuilder().build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("http://192.168.99.1:8080/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val cakesService by lazy{
        val cakesServiceApi = retrofit.create(CakesServiceApi::class.java)
        CakesService(cakesServiceApi)
    }
}