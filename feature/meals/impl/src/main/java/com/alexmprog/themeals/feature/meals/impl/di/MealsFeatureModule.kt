package com.alexmprog.themeals.feature.meals.impl.di

import com.alexmprog.themeals.feature.meals.api.domain.repository.MealsRepository
import com.alexmprog.themeals.feature.meals.impl.data.MealsRepositoryImpl
import com.alexmprog.themeals.feature.meals.impl.data.MealsService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MealsFeatureModule {

    @Binds
    @Singleton
    internal abstract fun bindsMealsRepository(
        mealsRepository: MealsRepositoryImpl
    ): MealsRepository

    @Provides
    internal fun providesMealsService(retrofit: Retrofit) =
        retrofit.create(MealsService::class.java)
}