package com.app.androidworldtime.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.androidworldtime.R
import kotlinx.android.synthetic.main.timezone_item.view.*

class TimezoneAdapter(
    var timezoneList: List<String> = listOf()
): RecyclerView.Adapter<TimezoneAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.timezone_item, parent, false)

        return ViewHolder(row)
    }

    override fun getItemCount(): Int {
        return this.timezoneList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.timezoneList[position])
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(timezone: String) {
            view._timezone.text = timezone
        }
    }
}