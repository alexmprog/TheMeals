package com.alexmprog.themeals.feature.meals.api.domain.repository

import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.meals.api.domain.model.Meal
import com.alexmprog.themeals.feature.meals.api.domain.model.MealDetails
import com.alexmprog.themeals.feature.meals.api.domain.model.MealsSearchSource
import kotlinx.coroutines.flow.Flow

interface MealsRepository {

    fun getMealsBySource(id: String, source: MealsSearchSource): Flow<Resource<List<Meal>>>

    fun getMealDetails(id: String): Flow<Resource<MealDetails>>
}