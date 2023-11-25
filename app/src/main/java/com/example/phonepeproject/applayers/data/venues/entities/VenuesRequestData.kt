package com.example.phonepeproject.applayers.data.venues.entities

data class VenuesRequestData (
    val page: Int,
    val lat: String,
    val lon: String,
    val range: String,
    val query: String
)