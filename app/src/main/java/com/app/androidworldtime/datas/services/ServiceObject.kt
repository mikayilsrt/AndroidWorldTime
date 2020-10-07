package com.app.androidworldtime.datas.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceObject {

    private const val apiBaseUrl: String = "http://worldtimeapi.org/api/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(apiBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}