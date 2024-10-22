package com.alexmprog.themeals.feature.meals.impl.di

import com.alexmprog.themeals.feature.meals.impl.data.network.MealsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object MealsDataModule {

    @Provides
    internal fun providesMealsService(retrofit: Retrofit) =
        retrofit.create(MealsService::class.java)
}