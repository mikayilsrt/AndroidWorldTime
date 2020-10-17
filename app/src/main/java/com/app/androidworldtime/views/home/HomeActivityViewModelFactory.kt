package com.app.androidworldtime.views.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.androidworldtime.datas.repository.TimezoneRepository
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class HomeActivityViewModelFactory(private val timezoneRepository: TimezoneRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeActivityViewModel::class.java)) {
            return HomeActivityViewModel(timezoneRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}