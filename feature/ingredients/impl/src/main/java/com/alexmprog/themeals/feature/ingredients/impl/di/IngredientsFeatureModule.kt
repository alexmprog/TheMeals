package com.alexmprog.themeals.feature.ingredients.impl.di

import com.alexmprog.themeals.feature.ingredients.impl.data.network.IngredientsService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import retrofit2.Retrofit

@Module
@ComponentScan("com.alexmprog.themeals.feature.ingredients.impl")
class IngredientsFeatureModule {

    @Factory
    internal fun providesIngredientsService(retrofit: Retrofit) =
        retrofit.create(IngredientsService::class.java)
}