package com.alexmprog.themeals.feature.categories.impl.di

import com.alexmprog.themeals.feature.categories.api.domain.repository.CategoriesRepository
import com.alexmprog.themeals.feature.categories.impl.data.network.CategoriesService
import com.alexmprog.themeals.feature.categories.impl.data.repository.CategoriesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CategoriesFeatureModule {

    @Binds
    @Singleton
    internal abstract fun bindsCategoriesRepository(
        categoriesRepository: CategoriesRepositoryImpl
    ): CategoriesRepository

    @Provides
    internal fun providesCategoriesService(retrofit: Retrofit) =
        retrofit.create(CategoriesService::class.java)
}