package com.example.phonepeproject.applayers.presentation.screens.venueslist.recyclerview

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities.Venue
import com.example.phonepeproject.applayers.domain.venues.entity.VenuesList
import com.example.phonepeproject.applayers.domain.venues.entity.VenuesRequest
import com.example.phonepeproject.applayers.domain.venues.usecase.GetVenuesUseCase
import kotlinx.coroutines.flow.reduce

class VenuesPagingSource(
    private val getVenuesUseCase: GetVenuesUseCase,
    private val initialRequest: VenuesRequest
) : PagingSource<Int, Venue>() {

    private var isNewData = true

    override fun getRefreshKey(state: PagingState<Int, Venue>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.let { anchorPage ->
                anchorPage.prevKey?.let { prevKey ->
                    prevKey + 1
                } ?: anchorPage.nextKey?.let { nextKey ->
                    nextKey - 1
                }
            }
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Venue> {
        val nextPage = if(isNewData) {
            isNewData = false
            1
        } else {
            params.key
        }
        val request = initialRequest.copy(page = nextPage ?: 1)

        return try {
            val venuesList = getVenuesUseCase.invoke(venuesRequest = request).reduce { _, value -> value }

            if (venuesList.error != null) {
                LoadResult.Error(venuesList.error)
            } else {
                LoadResult.Page(
                    data = venuesList.venuesList!!,
                    prevKey = null,
                    nextKey = nextPage?.plus(1)
                )
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}