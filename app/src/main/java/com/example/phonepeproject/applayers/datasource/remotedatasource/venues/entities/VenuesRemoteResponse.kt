package com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities


import com.google.gson.annotations.SerializedName

data class VenuesRemoteResponse(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("venues")
    val venues: List<Venue>
)