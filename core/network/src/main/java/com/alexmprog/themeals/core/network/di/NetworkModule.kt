package com.alexmprog.themeals.core.network.di

import com.alexmprog.themeals.core.network.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton
import retrofit2.Retrofit

@Module
@ComponentScan
class NetworkModule {

    @Singleton
    internal fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
        isLenient = false
    }

    @Singleton
    internal fun providesOkHttpCallFactory(): Call.Factory = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) setLevel(HttpLoggingInterceptor.Level.BODY)
            },
        ).build()

    @Singleton
    internal fun providesRetrofit(networkJson: Json, okhttpCallFactory: Call.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .callFactory { okhttpCallFactory.newCall(it) }
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .build()


}