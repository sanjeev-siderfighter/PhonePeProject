package com.example.phonepeproject.applayers.presentation.screens.venueslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.phonepeproject.applayers.domain.venues.entity.VenuesRequest
import com.example.phonepeproject.applayers.domain.venues.usecase.GetVenuesUseCase
import com.example.phonepeproject.applayers.presentation.screens.venueslist.recyclerview.VenuesPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VenuesListViewModel @Inject constructor(
    private val getVenuesUseCase: GetVenuesUseCase
) : ViewModel() {

    val pagingFlow = Pager(PagingConfig(pageSize = 20)) {
        VenuesPagingSource(
            getVenuesUseCase = getVenuesUseCase, initialRequest = VenuesRequest(
                page = 1,
                lat = "12.971599",
                lon = "77.594566",
                range = "12mi",
                query = ""
            )
        )
    }.flow
        .cachedIn(viewModelScope)
}