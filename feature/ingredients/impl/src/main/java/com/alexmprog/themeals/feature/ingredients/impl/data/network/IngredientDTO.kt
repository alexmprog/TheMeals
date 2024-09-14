package com.alexmprog.themeals.feature.ingredients.impl.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class IngredientsResponse(
    @SerialName("meals")
    val ingredients: List<IngredientDTO>
)

@Serializable
internal data class IngredientDTO(
    @SerialName("strIngredient")
    val name: String
)