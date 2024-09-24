package com.alexmprog.themeals.feature.meals.impl.di

import com.alexmprog.themeals.feature.meals.impl.data.MealsService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import retrofit2.Retrofit

@Module
@ComponentScan("com.alexmprog.themeals.feature.meals.impl")
class MealsFeatureModule {

    @Factory
    internal fun providesMealsService(retrofit: Retrofit) =
        retrofit.create(MealsService::class.java)
}