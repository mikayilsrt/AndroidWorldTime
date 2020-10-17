package com.app.androidworldtime.datas.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.androidworldtime.datas.models.Location
import com.app.androidworldtime.datas.services.ServiceObject
import com.app.androidworldtime.datas.services.TimezoneService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.core.Observer
import java.util.concurrent.TimeUnit

class TimezoneRepository {

    private val timezoneService: TimezoneService = ServiceObject.retrofit.create(TimezoneService::class.java)

    private val _timezone: MutableLiveData<List<String>> = MutableLiveData()
    fun getTimezone(): MutableLiveData<List<String>> {
        return this._timezone
    }

    private val _location: MutableLiveData<Location> = MutableLiveData()
    fun getLocation(): LiveData<Location> {
        return this._location
    }

    fun loadTimezone() {
        timezoneService.getTimezone()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: Observer<List<String>> {
                override fun onComplete() = Unit

                override fun onSubscribe(d: Disposable?) = Unit

                override fun onNext(t: List<String>?) {
                    this@TimezoneRepository._timezone.value = t
                }

                override fun onError(e: Throwable?) = Unit
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