package com.alexmprog.themeals.feature.meals.api.domain

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
    val ingredients: List<String>
)

enum class MealsSearchSource {
    Category, Ingredient, Area;
}