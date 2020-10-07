package com.app.androidworldtime.views.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.androidworldtime.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeActivityViewModelFactory: HomeActivityViewModelFactory = HomeActivityViewModelFactory(this)
        val homeActivityViewModel: HomeActivityViewModel = ViewModelProvider(this, homeActivityViewModelFactory).get(HomeActivityViewModel::class.java)

        homeActivityViewModel.getTimezone().observe(this, Observer {
            Log.d("Debug", it.size.toString())
        })

    }
}