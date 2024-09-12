package com.alexmprog.themeals.feature.ingredients.api.domain

import com.alexmprog.themeals.core.common.model.Resource
import kotlinx.coroutines.flow.Flow

class GetIngredientsUseCase(
    private val ingredientsRepository: IngredientsRepository
) {
    operator fun invoke(): Flow<Resource<List<Ingredient>>> = ingredientsRepository.getIngredients()
}