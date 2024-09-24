package com.alexmprog.themeals.feature.meals.api.domain.model

data class Meal(
    val id: String,
    val name: String,
    val image: String?
)

data class MealDetails(
    val id: String,
    val category: String,
    val area: String,
    val description: String,
    val youtubeUrl: String?,
    val measuredIngredients: List<String>
)

enum class MealsSearchSource {
    Category, Ingredient, Area;
}