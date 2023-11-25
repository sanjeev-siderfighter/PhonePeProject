package com.example.phonepeproject.applayers.domain.venues.entity

data class VenuesRequest (
    val page: Int,
    val lat: String,
    val lon: String,
    val range: String,
    val query: String
)