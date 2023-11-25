package com.example.phonepeproject.applayers.datasource.remotedatasource.venues

import com.example.phonepeproject.applayers.data.venues.entities.VenuesRequestData
import com.example.phonepeproject.applayers.data.venues.entities.VenuesResponseData
import com.example.phonepeproject.applayers.data.venues.repository.IVenuesRemoteDataSource
import com.example.phonepeproject.applayers.datasource.remotedatasource.CLIENT_ID
import com.example.phonepeproject.applayers.datasource.remotedatasource.RemoteApiClient
import com.example.phonepeproject.applayers.datasource.remotedatasource.utils.ApiResult
import com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities.VenuesRemoteResponse
import com.example.phonepeproject.providers.coroutineprovider.ICoroutineDispatcherProvider
import com.example.phonepeproject.utils.PER_PAGE_COUNT
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VenuesRemoteDataSource @Inject constructor(
    private val apiClient: RemoteApiClient,
    private val coroutineDispatcherProvider: ICoroutineDispatcherProvider
) : IVenuesRemoteDataSource {
    override suspend fun getVenues(venuesRequest: VenuesRequestData): ApiResult<VenuesResponseData> {
        return withContext(coroutineDispatcherProvider.io) {
            try {
                val venuesRemoteResponse = apiClient.getVenuesList(
                    clientId = CLIENT_ID,
                    perPage = PER_PAGE_COUNT,
                    page = venuesRequest.page,
                    lat = venuesRequest.lat,
                    lon = venuesRequest.lon,
                    range = venuesRequest.range,
                    query = venuesRequest.query
                )
                ApiResult.Success(venuesRemoteResponse.toVenuesResponseData())
            } catch (e: Exception) {
                ApiResult.Failure(e)
            }
        }
    }

    private fun VenuesRemoteResponse.toVenuesResponseData(): VenuesResponseData {
        return VenuesResponseData(
            meta = meta,
            venues = venues
        )
    }

}