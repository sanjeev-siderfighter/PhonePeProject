package com.example.phonepeproject.applayers.data.venues.entities

import com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities.Meta
import com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities.Venue

data class VenuesResponseData(
    val meta: Meta,
    val venues: List<Venue>
)