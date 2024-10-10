package com.alexmprog.themeals.feature.areas.impl.di

import com.alexmprog.themeals.core.common.dispatcher.CommonDispatchers
import com.alexmprog.themeals.core.common.dispatcher.Dispatcher
import com.alexmprog.themeals.core.database.dao.AreaDao
import com.alexmprog.themeals.feature.area.api.domain.repository.AreasRepository
import com.alexmprog.themeals.feature.area.api.domain.usecase.GetAreasUseCase
import com.alexmprog.themeals.feature.areas.impl.data.network.AreasService
import com.alexmprog.themeals.feature.areas.impl.data.repository.AreasRepositoryImpl
import com.alexmprog.themeals.feature.areas.impl.domain.usecase.GetAreasUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object AreasDataModule {

    @Provides
    @Singleton
    internal fun provideAreasRepository(
        areaDao: AreaDao,
        areasService: AreasService,
        @Dispatcher(CommonDispatchers.IO) dispatcher: CoroutineDispatcher
    ): AreasRepository = AreasRepositoryImpl(areaDao, areasService, dispatcher)

    @Provides
    internal fun providesGetAreasUseCase(areasRepository: AreasRepository): GetAreasUseCase =
        GetAreasUseCaseImpl(areasRepository)

    @Provides
    internal fun providesAreasService(retrofit: Retrofit) =
        retrofit.create(AreasService::class.java)
}