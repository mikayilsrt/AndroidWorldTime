package com.app.androidworldtime.views.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.androidworldtime.datas.repository.TimezoneRepository
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class LocationActivityViewModelFactory(private val timezoneRepository: TimezoneRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LocationActivityViewModel::class.java)) {
            return LocationActivityViewModel(timezoneRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}