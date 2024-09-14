package com.alexmprog.themeals.feature.ingredients.api.domain.usecase

import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.ingredients.api.domain.model.Ingredient
import kotlinx.coroutines.flow.Flow

interface GetIngredientsUseCase {

    operator fun invoke(): Flow<Resource<List<Ingredient>>>
}