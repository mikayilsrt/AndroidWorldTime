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

    private var timezoneAdapter: TimezoneAdapter? = null
    private var timezoneRepository: TimezoneRepository? = null
    private var homeActivityViewModel: HomeActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.initialRecyclerView()

        this.timezoneRepository = TimezoneRepository()

        val homeActivityViewModelFactory: HomeActivityViewModelFactory = HomeActivityViewModelFactory(timezoneRepository!!)
        this.homeActivityViewModel = ViewModelProvider(this, homeActivityViewModelFactory).get(HomeActivityViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()

        if (this.timezoneRepository != null)
            this.timezoneRepository?.loadTimezone()

        this.observeTimezoneList()
    }

    override fun onDestroy() {
        super.onDestroy()

        this.timezoneAdapter = null
        this.timezoneRepository = null
        this.homeActivityViewModel = null
    }

    private fun observeTimezoneList() {
        this.homeActivityViewModel!!.getTimezone().observe(this, Observer {
            this.timezoneAdapter?.timezoneList = it
            this.timezoneAdapter?.notifyDataSetChanged()
        })
    }

    private fun initialRecyclerView() {
        this.timezoneAdapter = TimezoneAdapter()
        _timezoneList.layoutManager = LinearLayoutManager(this)
        _timezoneList.adapter = this.timezoneAdapter
    }
}