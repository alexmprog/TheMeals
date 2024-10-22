package com.alexmprog.themeals.feature.ingredients.impl.di

import com.alexmprog.themeals.feature.ingredients.api.domain.repository.IngredientsRepository
import com.alexmprog.themeals.feature.ingredients.api.domain.usecase.GetIngredientsUseCase
import com.alexmprog.themeals.feature.ingredients.impl.data.repository.IngredientsRepositoryImpl
import com.alexmprog.themeals.feature.ingredients.impl.domain.usecase.GetIngredientsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface IngredientsDomainModule {

    @Binds
    @Singleton
    fun bindsIngredientsRepository(impl: IngredientsRepositoryImpl): IngredientsRepository

    @Binds
    fun providesGetIngredientsUseCase(impl: GetIngredientsUseCaseImpl): GetIngredientsUseCase
}