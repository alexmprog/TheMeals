package com.alexmprog.themeals.feature.meals.api.domain

import com.alexmprog.themeals.core.common.model.Resource
import kotlinx.coroutines.flow.Flow

class GetMealsUseCase(
    private val mealsRepository: MealsRepository
) {
    operator fun invoke(id: String, source: MealsSearchSource): Flow<Resource<List<Meal>>> =
        mealsRepository.getMealsBySource(id, source)
}