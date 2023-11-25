package com.example.phonepeproject.providers.coroutineprovider

import kotlinx.coroutines.CoroutineDispatcher

interface ICoroutineDispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}