package com.alexmprog.themeals.feature.areas.impl.di

import com.alexmprog.themeals.feature.areas.impl.data.network.AreasService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import retrofit2.Retrofit

@Module
@ComponentScan("com.alexmprog.themeals.feature.areas.impl")
class AreasFeatureModule {

    @Factory
    internal fun providesAreasService(retrofit: Retrofit) =
        retrofit.create(AreasService::class.java)
}