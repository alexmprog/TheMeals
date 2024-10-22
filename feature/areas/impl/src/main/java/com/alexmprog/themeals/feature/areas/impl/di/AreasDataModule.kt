package com.alexmprog.themeals.feature.areas.impl.di

import com.alexmprog.themeals.feature.areas.impl.data.network.AreasService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object AreasDataModule {

    @Provides
    internal fun providesAreasService(retrofit: Retrofit) =
        retrofit.create(AreasService::class.java)
}