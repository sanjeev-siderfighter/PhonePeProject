package com.example.phonepeproject.applayers.domain.venues.usecase

import com.example.phonepeproject.applayers.domain.venues.entity.VenuesList
import com.example.phonepeproject.applayers.domain.venues.entity.VenuesRequest
import com.example.phonepeproject.applayers.domain.venues.repository.IVenuesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVenuesUseCase @Inject constructor(
    private val venuesRepository: IVenuesRepository
) {
    suspend operator fun invoke(venuesRequest: VenuesRequest): Flow<VenuesList> {
        return venuesRepository.getVenues(venuesRequest)
        // do any business logic here if needed
    }
}