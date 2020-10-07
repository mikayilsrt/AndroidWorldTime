package com.app.androidworldtime.datas.repository

import androidx.lifecycle.MutableLiveData
import com.app.androidworldtime.datas.services.ServiceObject
import com.app.androidworldtime.datas.services.TimezoneService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TimezoneRepository {

    private val timezoneService: TimezoneService = ServiceObject.retrofit.create(TimezoneService::class.java)

    private val _timezone: MutableLiveData<List<String>> = MutableLiveData()
    fun getTimezone(): MutableLiveData<List<String>> {
        return this._timezone
    }

    fun loadTimezone() {
        timezoneService.getTimezone().enqueue(object: Callback<List<String>> {
            override fun onFailure(call: Call<List<String>>, t: Throwable) = Unit

            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                this@TimezoneRepository._timezone.value = response.body() ?: listOf()
            }
        })
    }

}