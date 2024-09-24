package com.alexmprog.themeals.feature.meals.impl.domain.usecase

import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.meals.api.domain.model.Meal
import com.alexmprog.themeals.feature.meals.api.domain.model.MealsSearchSource
import com.alexmprog.themeals.feature.meals.api.domain.repository.MealsRepository
import com.alexmprog.themeals.feature.meals.api.domain.usecase.GetMealsUseCase
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class GetMealsUseCaseImpl(private val mealsRepository: MealsRepository) : GetMealsUseCase {
    override operator fun invoke(
        id: String,
        source: MealsSearchSource
    ): Flow<Resource<List<Meal>>> =
        mealsRepository.getMealsBySource(id, source)
}