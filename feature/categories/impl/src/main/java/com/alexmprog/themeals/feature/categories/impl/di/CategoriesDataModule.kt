package com.alexmprog.themeals.feature.categories.impl.di

import com.alexmprog.themeals.core.common.dispatcher.CommonDispatchers
import com.alexmprog.themeals.core.common.dispatcher.Dispatcher
import com.alexmprog.themeals.core.database.dao.CategoryDao
import com.alexmprog.themeals.feature.categories.api.domain.repository.CategoriesRepository
import com.alexmprog.themeals.feature.categories.api.domain.usecase.GetCategoriesUseCase
import com.alexmprog.themeals.feature.categories.impl.data.network.CategoriesService
import com.alexmprog.themeals.feature.categories.impl.data.repository.CategoriesRepositoryImpl
import com.alexmprog.themeals.feature.categories.impl.domain.usecase.GetCategoriesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object CategoriesDataModule {

    @Provides
    @Singleton
    internal fun provideCategoriesRepository(
        categoryDao: CategoryDao,
        categoriesService: CategoriesService,
        @Dispatcher(CommonDispatchers.IO) dispatcher: CoroutineDispatcher
    ): CategoriesRepository = CategoriesRepositoryImpl(categoryDao, categoriesService, dispatcher)

    @Provides
    internal fun providesGetCategoriesUseCase(categoriesRepository: CategoriesRepository): GetCategoriesUseCase =
        GetCategoriesUseCaseImpl(categoriesRepository)

    @Provides
    internal fun providesCategoriesService(retrofit: Retrofit) =
        retrofit.create(CategoriesService::class.java)
}