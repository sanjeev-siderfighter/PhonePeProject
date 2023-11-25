package com.example.phonepeproject.applayers.presentation.screens.venueslist.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.phonepeproject.applayers.datasource.remotedatasource.venues.entities.Venue
import javax.inject.Inject

class VenuesListDiffUtils @Inject constructor() : DiffUtil.ItemCallback<Venue>() {
    override fun areItemsTheSame(oldItem: Venue, newItem: Venue): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Venue, newItem: Venue): Boolean {
        return oldItem == newItem
    }
}