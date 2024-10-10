package com.alexmprog.themeals.feature.meals.impl.domain.usecase

import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.meals.api.domain.model.MealDetails
import com.alexmprog.themeals.feature.meals.api.domain.repository.MealsRepository
import com.alexmprog.themeals.feature.meals.api.domain.usecase.GetMealDetailsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetMealDetailsUseCaseImpl @Inject constructor(private val mealsRepository: MealsRepository) :
    GetMealDetailsUseCase {
    override operator fun invoke(id: String): Flow<Resource<MealDetails>> =
        mealsRepository.getMealDetails(id)
}