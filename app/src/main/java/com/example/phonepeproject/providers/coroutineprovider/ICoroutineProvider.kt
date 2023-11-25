package com.example.phonepeproject.providers.coroutineprovider

import kotlinx.coroutines.CoroutineDispatcher

interface ICoroutineProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}