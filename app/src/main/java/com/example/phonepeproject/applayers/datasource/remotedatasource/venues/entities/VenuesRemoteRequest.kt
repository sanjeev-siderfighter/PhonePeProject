package com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities

data class VenuesRemoteRequest(
    val page: Int,
    val lat: String,
    val lon: String,
    val range: String,
    val query: String
)