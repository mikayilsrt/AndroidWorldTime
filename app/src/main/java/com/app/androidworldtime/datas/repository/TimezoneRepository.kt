package com.app.androidworldtime.datas.repository

import androidx.lifecycle.MutableLiveData
import com.app.androidworldtime.datas.models.Location
import com.app.androidworldtime.datas.services.ServiceObject
import com.app.androidworldtime.datas.services.TimezoneService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.core.Observer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class TimezoneRepository {

    private val timezoneService: TimezoneService = ServiceObject.retrofit.create(TimezoneService::class.java)

    private val _timezone: MutableLiveData<List<String>> = MutableLiveData()
    fun getTimezone(): MutableLiveData<List<String>> {
        return this._timezone
    }

    private val _location: MutableLiveData<Location> = MutableLiveData()
    fun getLocation(): MutableLiveData<Location> {
        return this._location
    }

    fun loadTimezone() {
        timezoneService.getTimezone().enqueue(object: Callback<List<String>> {
            override fun onFailure(call: Call<List<String>>, t: Throwable) = Unit

            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                this@TimezoneRepository._timezone.value = response.body() ?: listOf()
            }
        })
    }

    fun loadLocation(location: String) {
        timezoneService.getLocation(location)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .repeatWhen {
                it.delay(1, TimeUnit.SECONDS)
            }
            .subscribe(object: Observer<Location> {
                override fun onComplete() = Unit

                override fun onSubscribe(d: Disposable?) = Unit

                override fun onNext(t: Location?) {
                    this@TimezoneRepository._location.value = t
                }

                override fun onError(e: Throwable?) = Unit
            })
    }

}