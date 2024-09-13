package com.alexmprog.themeals.feature.meals.api.domain

import com.alexmprog.themeals.core.common.model.Resource
import kotlinx.coroutines.flow.Flow

class GetMealDetailsUseCase(
    private val mealsRepository: MealsRepository
) {
    operator fun invoke(id: String): Flow<Resource<MealDetails>> =
        mealsRepository.getMealDetails(id)
}