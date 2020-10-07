package com.app.androidworldtime.datas.services

import com.app.androidworldtime.datas.models.Location
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TimezoneService {

    @GET("timezone")
    fun getTimezone() : Call<List<String>>

    @GET("timezone/{location}")
    fun getLocation(
        @Path("location") location: String
    ) : Call<Location>

}