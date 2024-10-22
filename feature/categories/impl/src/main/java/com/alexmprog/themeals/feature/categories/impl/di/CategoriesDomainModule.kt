package com.alexmprog.themeals.feature.categories.impl.di

import com.alexmprog.themeals.feature.categories.api.domain.repository.CategoriesRepository
import com.alexmprog.themeals.feature.categories.api.domain.usecase.GetCategoriesUseCase
import com.alexmprog.themeals.feature.categories.impl.data.repository.CategoriesRepositoryImpl
import com.alexmprog.themeals.feature.categories.impl.domain.usecase.GetCategoriesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface CategoriesDomainModule {

    @Binds
    @Singleton
    fun provideCategoriesRepository(impl: CategoriesRepositoryImpl): CategoriesRepository

    @Binds
    fun providesGetCategoriesUseCase(impl: GetCategoriesUseCaseImpl): GetCategoriesUseCase
}