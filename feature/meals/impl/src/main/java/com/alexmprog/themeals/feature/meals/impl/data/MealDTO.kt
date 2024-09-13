package com.alexmprog.themeals.feature.meals.impl.data

import kotlinx.serialization.SerialInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
internal data class MealsResponse(
    @SerialName("meals")
    val meals: List<MealDTO>
)

@Serializable
internal data class MealDetailsResponse(
    @SerialName("meals")
    val meals: List<MealDetailsDTO>
)

@Serializable
internal data class MealDTO(
    @SerialName("idMeal")
    val id: String,
    @SerialName("strMeal")
    val name: String,
    @SerialName("strMealThumb")
    val image: String?
)

@Serializable
internal data class MealDetailsDTO(
    @SerialName("idMeal")
    val id: String,
    @SerialName("strCategory")
    val category: String,
    @SerialName("strArea")
    val area: String,
    @SerialName("strInstructions")
    val description: String,
    @SerialName("strYoutube")
    val youtubeUrl: String?,
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
    @SerialName("strMeasure1")
    val measure1: String?,
    @SerialName("strMeasure2")
    val measure2: String?,
    @SerialName("strMeasure3")
    val measure3: String?,
    @SerialName("strMeasure4")
    val measure4: String?,
    @SerialName("strMeasure5")
    val measure5: String?,
    @SerialName("strMeasure6")
    val measure6: String?,
    @SerialName("strMeasure7")
    val measure7: String?,
    @SerialName("strMeasure8")
    val measure8: String?,
    @SerialName("strMeasure9")
    val measure9: String?,
    @SerialName("strMeasure10")
    val measure10: String?,
    @SerialName("strMeasure11")
    val measure11: String?,
    @SerialName("strMeasure12")
    val measure12: String?,
    @SerialName("strMeasure13")
    val measure13: String?,
    @SerialName("strMeasure14")
    val measure14: String?,
    @SerialName("strMeasure15")
    val measure15: String?,
    @SerialName("strMeasure16")
    val measure16: String?,
    @SerialName("strMeasure17")
    val measure17: String?,
    @SerialName("strMeasure18")
    val measure18: String?,
    @SerialName("strMeasure19")
    val measure19: String?,
    @SerialName("strMeasure20")
    val measure20: String?,
)