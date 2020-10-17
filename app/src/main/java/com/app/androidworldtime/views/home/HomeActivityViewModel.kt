package com.app.androidworldtime.views.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.androidworldtime.datas.repository.TimezoneRepository

class HomeActivityViewModel(private val timezoneRepository: TimezoneRepository) : ViewModel() {

    fun getTimezone(): MutableLiveData<List<String>> {
        return this.timezoneRepository.getTimezone()
    }

}