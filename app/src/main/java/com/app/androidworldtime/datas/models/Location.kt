package com.app.androidworldtime.datas.models

class Location(
    var abbreviation: String? = "",
    var client_ip: String? = "",
    var datetime: String? = "",
    var day_of_week: Int? = null,
    var day_of_year: Int? = null,
    var dst: Boolean? = null,
    var dst_from: String? = null,
    var dst_offset: Int? = null,
    var dst_until: String? = null,
    var raw_offset: Int? = null,
    var timezone: String? = "",
    var unixtime: Int? = null,
    var utc_datetime: String? = "",
    var utc_offset: String? = "",
    var week_number: Int? = null
)