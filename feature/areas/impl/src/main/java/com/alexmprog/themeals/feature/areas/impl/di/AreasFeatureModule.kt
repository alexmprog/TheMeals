package com.alexmprog.themeals.feature.areas.impl.di

import com.alexmprog.themeals.core.common.dispatcher.CommonDispatchers
import com.alexmprog.themeals.core.common.dispatcher.Dispatcher
import com.alexmprog.themeals.core.database.dao.AreaDao
import com.alexmprog.themeals.feature.areas.impl.data.network.AreasService
import com.alexmprog.themeals.feature.areas.impl.data.repository.AreasRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object AreasFeatureModule {

    @Provides
    @Singleton
    internal fun provideAreasRepository(
        areaDao: AreaDao,
        areasService: AreasService,
        @Dispatcher(CommonDispatchers.IO) dispatcher: CoroutineDispatcher
    ) = AreasRepositoryImpl(areaDao, areasService, dispatcher)

    @Provides
    internal fun providesAreasService(retrofit: Retrofit) =
        retrofit.create(AreasService::class.java)
}