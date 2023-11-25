package com.example.phonepeproject.providers.di

import com.example.phonepeproject.providers.coroutineprovider.CoroutineDispatcherProvider
import com.example.phonepeproject.providers.coroutineprovider.ICoroutineDispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProviderModule {
    @Binds
    abstract fun bindCoroutineProvider(coroutineDispatcherProvider: CoroutineDispatcherProvider): ICoroutineDispatcherProvider
}