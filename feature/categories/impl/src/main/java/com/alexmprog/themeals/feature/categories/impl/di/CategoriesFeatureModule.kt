package com.alexmprog.themeals.feature.categories.impl.di

import com.alexmprog.themeals.feature.categories.impl.data.network.CategoriesService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import retrofit2.Retrofit

@Module
@ComponentScan("com.alexmprog.themeals.feature.categories.impl")
class CategoriesFeatureModule {

    @Factory
    internal fun providesCategoriesService(retrofit: Retrofit) =
        retrofit.create(CategoriesService::class.java)
}