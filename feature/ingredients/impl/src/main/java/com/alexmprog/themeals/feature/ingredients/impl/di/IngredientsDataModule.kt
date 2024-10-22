package com.alexmprog.themeals.feature.ingredients.impl.di

import com.alexmprog.themeals.feature.ingredients.impl.data.network.IngredientsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object IngredientsDataModule {

    @Provides
    internal fun providesIngredientsService(retrofit: Retrofit) =
        retrofit.create(IngredientsService::class.java)
}