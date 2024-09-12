package com.alexmprog.themeals.feature.meals.api.domain

import com.alexmprog.themeals.core.common.model.Resource
import kotlinx.coroutines.flow.Flow

interface MealsRepository {

    fun getMealsBySource(id: String, source: MealsSearchSource): Flow<Resource<List<Meal>>>

    fun getMealDetails(id: Int): Flow<Resource<MealDetails>>
}