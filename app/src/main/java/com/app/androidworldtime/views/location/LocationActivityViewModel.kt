package com.app.androidworldtime.views.location

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.app.androidworldtime.datas.models.Location
import com.app.androidworldtime.datas.repository.TimezoneRepository

class LocationActivityViewModel(
    context: AppCompatActivity,
    private val timezoneLocation: String
) : ViewModel() {

    private val _location: MutableLiveData<Location> = MutableLiveData()
    fun getLocation(): MutableLiveData<Location> {
        return this._location
    }

    private val timezoneRepository: TimezoneRepository = TimezoneRepository()

    init {
        this.timezoneRepository.loadLocation(this.timezoneLocation)
        this.timezoneRepository.getLocation().observe(context, Observer {
            this._location.value = it
        })
    }
}