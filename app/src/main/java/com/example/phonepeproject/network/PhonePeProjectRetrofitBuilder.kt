package com.example.phonepeproject.network

import com.example.phonepeproject.BuildConfig
import com.example.phonepeproject.applayers.datasource.remotedatasource.BASE_URL
import com.example.phonepeproject.applayers.datasource.remotedatasource.RemoteApiClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PhonePeProjectRetrofitBuilder {
    fun buildComicsRemoteApiClient(): RemoteApiClient {
        val retrofit = buildRetrofit(baseUrl = BASE_URL)
        return retrofit.create(RemoteApiClient::class.java)
    }

    private fun buildRetrofit(baseUrl: String): Retrofit {
        val okHttpClient = OkHttpClient.Builder().also {
            if (BuildConfig.DEBUG) {
                it.addInterceptor(interceptor = getLoggingInterceptor())
            }
        }.build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}