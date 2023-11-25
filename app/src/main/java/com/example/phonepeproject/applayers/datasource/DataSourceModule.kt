package com.example.phonepeproject.applayers.datasource

import com.example.phonepeproject.applayers.datasource.remotedatasource.RemoteApiClient
import com.example.phonepeproject.network.PhonePeProjectRetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Provides
    fun provideRemoteApiClient(): RemoteApiClient {
        return PhonePeProjectRetrofitBuilder.buildComicsRemoteApiClient()
    }
}