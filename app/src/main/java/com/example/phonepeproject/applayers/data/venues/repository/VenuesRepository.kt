package com.example.phonepeproject.applayers.data.venues.repository

import com.example.phonepeproject.applayers.data.venues.entities.VenuesRequestData
import com.example.phonepeproject.applayers.data.venues.entities.VenuesResponseData
import com.example.phonepeproject.applayers.datasource.remotedatasource.utils.ApiResult
import com.example.phonepeproject.applayers.domain.venues.entity.VenuesList
import com.example.phonepeproject.applayers.domain.venues.entity.VenuesRequest
import com.example.phonepeproject.applayers.domain.venues.repository.IVenuesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VenuesRepository @Inject constructor(
    private val remoteDataSource: IVenuesRemoteDataSource
) : IVenuesRepository {
    override suspend fun getVenues(venuesRequest: VenuesRequest): Flow<VenuesList> {
        return flow {
            val remoteData = remoteDataSource.getVenues(venuesRequest.toVenuesRequestData())
            emit(
                when (remoteData) {
                    is ApiResult.Failure -> {
                        VenuesList(null, null, remoteData.exception)
                    }

                    is ApiResult.Success -> {
                        remoteData.response.toVenuesList()
                    }
                }
            )
        }
    }

    private fun VenuesRequest.toVenuesRequestData(): VenuesRequestData {
        return VenuesRequestData(
            page, lat, lon, range, query
        )
    }

    private fun VenuesResponseData.toVenuesList(): VenuesList {
        return VenuesList(
            venuesList = venues, meta = meta
        )
    }
}