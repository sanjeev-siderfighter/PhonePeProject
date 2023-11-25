package com.example.phonepeproject.applayers.presentation.screens.venueslist.uistate

import com.example.phonepeproject.applayers.domain.venues.entity.VenuesList

sealed interface VenuesListUiState {
    data object Loading : VenuesListUiState
    data object Error : VenuesListUiState
    data class Success(val venusList: VenuesList) : VenuesListUiState
}