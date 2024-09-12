package com.alexmprog.themeals.feature.ingredients.impl.di

import com.alexmprog.themeals.feature.ingredients.api.domain.GetIngredientsUseCase
import com.alexmprog.themeals.feature.ingredients.api.domain.IngredientsRepository
import com.alexmprog.themeals.feature.ingredients.impl.data.IngredientsService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import retrofit2.Retrofit

@Module
@ComponentScan
class IngredientsFeatureModule {

    @Factory
    internal fun providesIngredientsService(retrofit: Retrofit) =
        retrofit.create(IngredientsService::class.java)

    @Factory
    internal fun providesCategoriesService(repository: IngredientsRepository) =
        GetIngredientsUseCase(repository)
}