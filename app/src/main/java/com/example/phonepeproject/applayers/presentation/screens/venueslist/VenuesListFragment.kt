package com.example.phonepeproject.applayers.presentation.screens.venueslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.phonepeproject.applayers.domain.venues.entity.VenuesList
import com.example.phonepeproject.applayers.presentation.screens.venueslist.recyclerview.VenuesListAdapter
import com.example.phonepeproject.applayers.presentation.screens.venueslist.uistate.VenuesListUiState
import com.example.phonepeproject.databinding.FragmentVenuesListBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class VenuesListFragment : Fragment() {

    private lateinit var binding: FragmentVenuesListBinding
    private val viewModel by viewModels<VenuesListViewModel>()

    @Inject
    lateinit var venuesListAdapter: VenuesListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentVenuesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        setupViewModelObservers()
        setOnClickListeners()
    }

    private fun setupViewModelObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.venuesListFlow.collectLatest { venuesListUiState ->
                        handleVenuesListUiState(venuesListUiState)
                    }
                }
            }
        }
    }

    private fun handleVenuesListUiState(venuesListUiState: VenuesListUiState) {
        when (venuesListUiState) {
            VenuesListUiState.Error -> {
                Snackbar.make(binding.root, "This is Error Case", Snackbar.LENGTH_INDEFINITE).show()
            }

            VenuesListUiState.Loading -> {
                Snackbar.make(binding.root, "Loading Venues List", Snackbar.LENGTH_LONG).show()
            }

            is VenuesListUiState.Success -> {
                updateRecyclerView(venuesList = venuesListUiState.venusList)
            }
        }
    }

    private fun setOnClickListeners() {
        binding.imgClose.setOnClickListener {
            activity?.finish()
        }
    }

    private fun initRecyclerView() {
        binding.rvVenuesList.adapter = venuesListAdapter
    }

    private fun updateRecyclerView(venuesList: VenuesList) {
        venuesListAdapter.submitList(venuesList.venuesList)
    }
}