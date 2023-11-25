package com.example.phonepeproject.applayers.data.di

import com.example.phonepeproject.applayers.data.venues.repository.IVenuesRemoteDataSource
import com.example.phonepeproject.applayers.datasource.remotedatasource.venues.VenuesRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindVenuesRemoteDataSource(venuesRemoteDataSource: VenuesRemoteDataSource): IVenuesRemoteDataSource
}