package com.app.androidworldtime.views.home

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.app.androidworldtime.datas.repository.TimezoneRepository

class HomeActivityViewModel(context: AppCompatActivity) : ViewModel() {

    private var _timezone: MutableLiveData<List<String>> = MutableLiveData()
    fun getTimezone(): MutableLiveData<List<String>> {
        return this._timezone
    }

    private val timezoneRepository: TimezoneRepository = TimezoneRepository()

    init {
        this.timezoneRepository.loadTimezone()
        this.timezoneRepository.getTimezone().observe(context, Observer {
            this._timezone.value = it
        })
    }

}