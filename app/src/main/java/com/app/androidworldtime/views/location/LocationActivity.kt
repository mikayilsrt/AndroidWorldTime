package com.app.androidworldtime.views.location

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.androidworldtime.R
import com.app.androidworldtime.datas.repository.TimezoneRepository
import kotlinx.android.synthetic.main.activity_location.*

class LocationActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_LOCATION: String = "EXTRA_LOCATION"

        fun start(context: Context, location: String) {
            context.startActivity(Intent(context, LocationActivity::class.java).putExtra(EXTRA_LOCATION, location))
        }
    }

    private val locationExtra by lazy {
        intent.getStringExtra(EXTRA_LOCATION)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        val timezoneRepository: TimezoneRepository = TimezoneRepository()
        timezoneRepository.loadLocation(locationExtra ?: "")

        val locationActivityViewModelFactory: LocationActivityViewModelFactory = LocationActivityViewModelFactory(timezoneRepository)
        val locationActivityViewModel: LocationActivityViewModel = ViewModelProvider(this, locationActivityViewModelFactory).get(LocationActivityViewModel::class.java)

        locationActivityViewModel.getLocation().observe(this, Observer {
            _datetime.text = it.datetime.toString()
        })
    }
}