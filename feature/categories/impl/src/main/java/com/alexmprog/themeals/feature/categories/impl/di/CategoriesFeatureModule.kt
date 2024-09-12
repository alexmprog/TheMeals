package com.alexmprog.themeals.feature.categories.impl.di

import com.alexmprog.themeals.feature.categories.api.domain.CategoriesRepository
import com.alexmprog.themeals.feature.categories.api.domain.GetCategoriesUseCase
import com.alexmprog.themeals.feature.categories.impl.data.CategoriesService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import retrofit2.Retrofit

@Module
@ComponentScan
class CategoriesFeatureModule {

    @Factory
    internal fun providesCategoriesService(retrofit: Retrofit) =
        retrofit.create(CategoriesService::class.java)

    @Factory
    internal fun providesCategoriesService(repository: CategoriesRepository) =
        GetCategoriesUseCase(repository)
}