package com.alexmprog.themeals.feature.ingredients.impl.di

import com.alexmprog.themeals.core.common.dispatcher.CommonDispatchers
import com.alexmprog.themeals.core.common.dispatcher.Dispatcher
import com.alexmprog.themeals.core.database.dao.IngredientDao
import com.alexmprog.themeals.feature.ingredients.api.domain.repository.IngredientsRepository
import com.alexmprog.themeals.feature.ingredients.api.domain.usecase.GetIngredientsUseCase
import com.alexmprog.themeals.feature.ingredients.impl.data.network.IngredientsService
import com.alexmprog.themeals.feature.ingredients.impl.data.repository.IngredientsRepositoryImpl
import com.alexmprog.themeals.feature.ingredients.impl.domain.usecase.GetIngredientsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object IngredientsDataModule {

    @Provides
    @Singleton
    internal fun bindsIngredientsRepository(
        ingredientDao: IngredientDao,
        ingredientsService: IngredientsService,
        @Dispatcher(CommonDispatchers.IO) dispatcher: CoroutineDispatcher
    ): IngredientsRepository =
        IngredientsRepositoryImpl(ingredientDao, ingredientsService, dispatcher)

    @Provides
    internal fun providesGetIngredientsUseCase(ingredientsRepository: IngredientsRepository): GetIngredientsUseCase =
        GetIngredientsUseCaseImpl(ingredientsRepository)

    @Provides
    internal fun providesIngredientsService(retrofit: Retrofit) =
        retrofit.create(IngredientsService::class.java)
}