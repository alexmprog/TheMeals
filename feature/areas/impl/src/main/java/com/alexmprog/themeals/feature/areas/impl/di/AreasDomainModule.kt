package com.alexmprog.themeals.feature.areas.impl.di

import com.alexmprog.themeals.feature.area.api.domain.repository.AreasRepository
import com.alexmprog.themeals.feature.area.api.domain.usecase.GetAreasUseCase
import com.alexmprog.themeals.feature.areas.impl.data.repository.AreasRepositoryImpl
import com.alexmprog.themeals.feature.areas.impl.domain.usecase.GetAreasUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface AreasDomainModule {

    @Binds
    @Singleton
    fun bindsAreasRepository(impl: AreasRepositoryImpl): AreasRepository

    @Binds
    fun bindsGetAreasUseCase(impl: GetAreasUseCaseImpl): GetAreasUseCase
}