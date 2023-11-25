package com.example.phonepeproject.applayers.domain.venues.repository

import com.example.phonepeproject.applayers.domain.venues.entity.VenuesList
import com.example.phonepeproject.applayers.domain.venues.entity.VenuesRequest
import kotlinx.coroutines.flow.Flow

interface IVenuesRepository {
    suspend fun getVenues(venuesRequest: VenuesRequest): Flow<VenuesList>
}