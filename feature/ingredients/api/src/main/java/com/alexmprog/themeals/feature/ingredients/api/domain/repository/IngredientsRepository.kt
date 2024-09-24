package com.alexmprog.themeals.feature.ingredients.api.domain.repository

import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.ingredients.api.domain.model.Ingredient
import kotlinx.coroutines.flow.Flow

interface IngredientsRepository {

    fun getIngredients(): Flow<Resource<List<Ingredient>>>
}