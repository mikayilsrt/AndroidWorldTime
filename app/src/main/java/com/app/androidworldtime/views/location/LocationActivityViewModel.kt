package com.app.androidworldtime.views.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.androidworldtime.datas.models.Location
import com.app.androidworldtime.datas.repository.TimezoneRepository

class LocationActivityViewModel(
    private val timezoneRepository: TimezoneRepository
) : ViewModel() {

    fun getLocation(): LiveData<Location> {
        return this.timezoneRepository.getLocation()
    }

}