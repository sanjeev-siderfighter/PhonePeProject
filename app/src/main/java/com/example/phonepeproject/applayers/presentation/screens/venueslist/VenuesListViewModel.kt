package com.example.phonepeproject.applayers.presentation.screens.venueslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phonepeproject.applayers.domain.venues.entity.VenuesRequest
import com.example.phonepeproject.applayers.domain.venues.usecase.GetVenuesUseCase
import com.example.phonepeproject.applayers.presentation.screens.venueslist.uistate.VenuesListUiState
import com.example.phonepeproject.providers.coroutineprovider.CoroutineDispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VenuesListViewModel @Inject constructor(
    private val getVenuesUseCase: GetVenuesUseCase,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {

    private val _venuesListFlow = MutableStateFlow<VenuesListUiState>(VenuesListUiState.Loading)
    val venuesListFlow = _venuesListFlow.asStateFlow()

    init {
        getVenuesList()
    }

    private fun getVenuesList() {
        viewModelScope.launch(coroutineDispatcherProvider.io) {
            getVenuesUseCase.invoke(
                venuesRequest = VenuesRequest(
                    page = 1,
                    lat = "12.971599",
                    lon = "77.594566",
                    range = "12mi",
                    query = ""
                )
            )
                .onStart {
                    _venuesListFlow.value = VenuesListUiState.Loading
                }
                .catch {
                    _venuesListFlow.value = VenuesListUiState.Error
                }
                .collectLatest { venuesList ->
                    _venuesListFlow.value = if (venuesList.error != null) {
                        VenuesListUiState.Error
                    } else {
                        VenuesListUiState.Success(venusList = venuesList)
                    }
                }
        }
    }
}