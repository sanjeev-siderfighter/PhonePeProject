package com.example.phonepeproject.applayers.domain.di

import com.example.phonepeproject.applayers.data.venues.repository.VenuesRepository
import com.example.phonepeproject.applayers.domain.venues.repository.IVenuesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {
    @Binds
    abstract fun bindVenuesRepository(venuesRepository: VenuesRepository): IVenuesRepository
}