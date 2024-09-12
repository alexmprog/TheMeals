package com.alexmprog.themeals.feature.meals.impl.di

import com.alexmprog.themeals.feature.meals.api.domain.GetMealsUseCase
import com.alexmprog.themeals.feature.meals.api.domain.MealsRepository
import com.alexmprog.themeals.feature.meals.impl.data.MealsService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import retrofit2.Retrofit

@Module
@ComponentScan
class MealsFeatureModule {

    @Factory
    internal fun providesMealsService(retrofit: Retrofit) =
        retrofit.create(MealsService::class.java)

    @Factory
    internal fun providesGetMealsUseCase(repository: MealsRepository) =
        GetMealsUseCase(repository)
}