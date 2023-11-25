package com.example.phonepeproject.applayers.presentation.screens.venueslist.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities.Venue
import com.example.phonepeproject.databinding.VenueItemLayoutBinding

class VenuesListViewHoler(private val binding: VenueItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(venue: Venue?) {
        with(binding) {
            tvVenueLat.text = venue?.location?.lat?.toString()
            tvVenueLon.text = venue?.location?.lon?.toString()
            tvVenueName.text = venue?.name
        }
    }
}