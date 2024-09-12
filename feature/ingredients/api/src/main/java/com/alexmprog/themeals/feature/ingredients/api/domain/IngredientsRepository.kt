package com.alexmprog.themeals.feature.ingredients.api.domain

import com.alexmprog.themeals.core.common.model.Resource
import kotlinx.coroutines.flow.Flow

interface IngredientsRepository {

    fun getIngredients(): Flow<Resource<List<Ingredient>>>
}