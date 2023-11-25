package com.example.phonepeproject.applayers.domain.venues.entity

import com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities.Meta
import com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities.Venue

data class VenuesList(
    val venuesList: List<Venue>?,
    val meta: Meta?,
    val error: Exception? = null
)