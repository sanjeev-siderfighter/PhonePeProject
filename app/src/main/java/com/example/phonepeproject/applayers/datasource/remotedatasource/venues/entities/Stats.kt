package com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("event_count")
    val eventCount: Int
)