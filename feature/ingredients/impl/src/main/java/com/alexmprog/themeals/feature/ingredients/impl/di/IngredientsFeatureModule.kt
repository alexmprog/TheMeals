package com.alexmprog.themeals.feature.ingredients.impl.di

import com.alexmprog.themeals.feature.ingredients.api.domain.repository.IngredientsRepository
import com.alexmprog.themeals.feature.ingredients.impl.data.network.IngredientsService
import com.alexmprog.themeals.feature.ingredients.impl.data.repository.IngredientsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class IngredientsFeatureModule {

    @Binds
    @Singleton
    internal abstract fun bindsIngredientsRepository(
        ingredientsRepository: IngredientsRepositoryImpl
    ): IngredientsRepository

    @Provides
    internal fun providesIngredientsService(retrofit: Retrofit) =
        retrofit.create(IngredientsService::class.java)
}