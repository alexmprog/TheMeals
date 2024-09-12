package com.alexmprog.themeals.core.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MealsResponse(
    @SerialName("meals")
    val cocktails: List<MealDTO>
)

@Serializable
internal data class MealDetailsResponse(
    @SerialName("meals")
    val cocktails: List<MealDetailsDTO>
)

@Serializable
data class MealDTO(
    @SerialName("idMeal")
    val id: String,
    @SerialName("strMeal")
    val name: String,
    @SerialName("strMealThumb")
    val image: String?
)

@Serializable
data class MealDetailsDTO(
    @SerialName("idDrink")
    val id: Int,
    @SerialName("strCategory")
    val category: String,
    @SerialName("strArea")
    val area: String,
    @SerialName("strInstructions")
    val description: String?,
    @SerialName("strIngredient1")
    val ingredient1: String?,
    @SerialName("strIngredient2")
    val ingredient2: String?,
    @SerialName("strIngredient3")
    val ingredient3: String?,
    @SerialName("strIngredient4")
    val ingredient4: String?,
    @SerialName("strIngredient5")
    val ingredient5: String?,
    @SerialName("strIngredient6")
    val ingredient6: String?,
    @SerialName("strIngredient7")
    val ingredient7: String?,
    @SerialName("strIngredient8")
    val ingredient8: String?,
    @SerialName("strIngredient9")
    val ingredient9: String?,
    @SerialName("strIngredient10")
    val ingredient10: String?,
    @SerialName("strIngredient11")
    val ingredient11: String?,
    @SerialName("strIngredient12")
    val ingredient12: String?,
    @SerialName("strIngredient13")
    val ingredient13: String?,
    @SerialName("strIngredient14")
    val ingredient14: String?,
    @SerialName("strIngredient15")
    val ingredient15: String?,
    @SerialName("strIngredient16")
    val ingredient16: String?,
    @SerialName("strIngredient17")
    val ingredient17: String?,
    @SerialName("strIngredient18")
    val ingredient18: String?,
    @SerialName("strIngredient19")
    val ingredient19: String?,
    @SerialName("strIngredient20")
    val ingredient20: String?,
)