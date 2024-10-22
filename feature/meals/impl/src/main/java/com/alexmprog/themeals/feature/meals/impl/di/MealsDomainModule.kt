package com.alexmprog.themeals.feature.meals.impl.di

import com.alexmprog.themeals.feature.meals.api.domain.repository.MealsRepository
import com.alexmprog.themeals.feature.meals.api.domain.usecase.GetMealDetailsUseCase
import com.alexmprog.themeals.feature.meals.api.domain.usecase.GetMealsUseCase
import com.alexmprog.themeals.feature.meals.impl.data.repository.MealsRepositoryImpl
import com.alexmprog.themeals.feature.meals.impl.domain.usecase.GetMealDetailsUseCaseImpl
import com.alexmprog.themeals.feature.meals.impl.domain.usecase.GetMealsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface MealsDomainModule {

    @Binds
    @Singleton
    fun bindsMealsRepository(impl: MealsRepositoryImpl): MealsRepository

    @Binds
    fun bindsGetMealsUseCase(impl: GetMealsUseCaseImpl): GetMealsUseCase

    @Binds
    fun bindsGetMealDetailsUseCase(impl: GetMealDetailsUseCaseImpl): GetMealDetailsUseCase
}