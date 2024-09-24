package com.alexmprog.themeals.feature.meals.api.domain.usecase

import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.meals.api.domain.model.Meal
import com.alexmprog.themeals.feature.meals.api.domain.model.MealsSearchSource
import kotlinx.coroutines.flow.Flow

interface GetMealsUseCase {

    operator fun invoke(id: String, source: MealsSearchSource): Flow<Resource<List<Meal>>>
}