package com.alexmprog.themeals.feature.categories.impl.di

import com.alexmprog.themeals.feature.categories.impl.data.network.CategoriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object CategoriesDataModule {

    @Provides
    internal fun providesCategoriesService(retrofit: Retrofit) =
        retrofit.create(CategoriesService::class.java)
}