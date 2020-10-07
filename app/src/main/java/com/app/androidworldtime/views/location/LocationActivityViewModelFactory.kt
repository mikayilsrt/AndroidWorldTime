package com.app.androidworldtime.views.location

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class LocationActivityViewModelFactory(private val context: AppCompatActivity, private val timezoneLocation: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LocationActivityViewModel::class.java)) {
            return LocationActivityViewModel(context, timezoneLocation) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}