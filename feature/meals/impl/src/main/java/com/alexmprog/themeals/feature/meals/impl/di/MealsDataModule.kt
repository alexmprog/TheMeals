package com.alexmprog.themeals.feature.meals.impl.di

import com.alexmprog.themeals.core.common.dispatcher.CommonDispatchers
import com.alexmprog.themeals.core.common.dispatcher.Dispatcher
import com.alexmprog.themeals.feature.meals.api.domain.repository.MealsRepository
import com.alexmprog.themeals.feature.meals.api.domain.usecase.GetMealDetailsUseCase
import com.alexmprog.themeals.feature.meals.api.domain.usecase.GetMealsUseCase
import com.alexmprog.themeals.feature.meals.impl.data.repository.MealsRepositoryImpl
import com.alexmprog.themeals.feature.meals.impl.data.network.MealsService
import com.alexmprog.themeals.feature.meals.impl.domain.usecase.GetMealDetailsUseCaseImpl
import com.alexmprog.themeals.feature.meals.impl.domain.usecase.GetMealsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object MealsDataModule {

    @Provides
    @Singleton
    internal fun bindsMealsRepository(
        mealsService: MealsService,
        @Dispatcher(CommonDispatchers.IO) dispatcher: CoroutineDispatcher
    ): MealsRepository = MealsRepositoryImpl(mealsService, dispatcher)

    @Provides
    internal fun providesGetMealsUseCase(mealsRepository: MealsRepository): GetMealsUseCase =
        GetMealsUseCaseImpl(mealsRepository)

    @Provides
    internal fun providesGetMealDetailsUseCase(mealsRepository: MealsRepository): GetMealDetailsUseCase =
        GetMealDetailsUseCaseImpl(mealsRepository)

    @Provides
    internal fun providesMealsService(retrofit: Retrofit) =
        retrofit.create(MealsService::class.java)
}