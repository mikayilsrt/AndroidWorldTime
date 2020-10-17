package com.app.androidworldtime.views.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.androidworldtime.R
import com.app.androidworldtime.adapters.TimezoneAdapter
import com.app.androidworldtime.datas.repository.TimezoneRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var timezoneAdapter: TimezoneAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.initialRecyclerView()

        val timezoneRepository: TimezoneRepository = TimezoneRepository()
        timezoneRepository.loadTimezone()

        val homeActivityViewModelFactory: HomeActivityViewModelFactory = HomeActivityViewModelFactory(timezoneRepository)
        val homeActivityViewModel: HomeActivityViewModel = ViewModelProvider(this, homeActivityViewModelFactory).get(HomeActivityViewModel::class.java)

        homeActivityViewModel.getTimezone().observe(this, Observer {
            this.timezoneAdapter.timezoneList = it
            this.timezoneAdapter.notifyDataSetChanged()
        })
    }

    private fun initialRecyclerView() {
        this.timezoneAdapter = TimezoneAdapter()
        _timezoneList.layoutManager = LinearLayoutManager(this)
        _timezoneList.adapter = this.timezoneAdapter
    }
}