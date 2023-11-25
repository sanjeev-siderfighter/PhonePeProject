package com.example.phonepeproject.applayers.datasource.remotedatasource

import com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities.VenuesRemoteResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApiClient {
    @GET("/2/venues")
    suspend fun getVenuesList(
        @Query("client_id") clientId: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("range") range: String,
        @Query("q") query: String
    ): VenuesRemoteResponse
}