package com.example.phonepeproject.applayers.data.venues.repository

import com.example.phonepeproject.applayers.data.venues.entities.VenuesRequestData
import com.example.phonepeproject.applayers.data.venues.entities.VenuesResponseData
import com.example.phonepeproject.applayers.datasource.remotedatasource.utils.ApiResult

interface IVenuesRemoteDataSource {
    suspend fun getVenues(venuesRequest: VenuesRequestData): ApiResult<VenuesResponseData>
}