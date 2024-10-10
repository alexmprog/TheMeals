package com.alexmprog.themeals.feature.ingredients.impl.domain.usecase

import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.ingredients.api.domain.repository.IngredientsRepository
import com.alexmprog.themeals.feature.ingredients.api.domain.model.Ingredient
import com.alexmprog.themeals.feature.ingredients.api.domain.usecase.GetIngredientsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetIngredientsUseCaseImpl @Inject constructor(
    private val ingredientsRepository: IngredientsRepository
) : GetIngredientsUseCase {
    override operator fun invoke(): Flow<Resource<List<Ingredient>>> =
        ingredientsRepository.getIngredients()
}