package com.alexmprog.themeals.core.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class IngredientsResponse(
    @SerialName("meals")
    val ingredients: List<IngredientDTO>
)

@Serializable
data class IngredientDTO(
    @SerialName("strIngredient1")
    val name: String
)