package com.alexmprog.themeals.feature.meals.api.domain.usecase

import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.meals.api.domain.model.MealDetails
import kotlinx.coroutines.flow.Flow

interface GetMealDetailsUseCase {

    operator fun invoke(id: String): Flow<Resource<MealDetails>>
}