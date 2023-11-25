package com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)