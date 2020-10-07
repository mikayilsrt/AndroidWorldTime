package com.app.androidworldtime.datas.services

import retrofit2.Call
import retrofit2.http.GET

interface TimezoneService {

    @GET("timezone")
    fun getTimezone() : Call<List<String>>

}