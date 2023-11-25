package com.example.phonepeproject.applayers.presentation.screens.venueslist.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities.Venue
import com.example.phonepeproject.databinding.VenueItemLayoutBinding
import javax.inject.Inject

class VenuesListAdapter @Inject constructor(venuesListDiffUtils: VenuesListDiffUtils) :
    ListAdapter<Venue, VenuesListViewHoler>(
        venuesListDiffUtils
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenuesListViewHoler {
        return VenuesListViewHoler(
            binding = VenueItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: VenuesListViewHoler, position: Int) {
        return holder.bind(getItem(position))
    }
}