package com.alexmprog.themeals.feature.meals.impl.data.network

import retrofit2.http.GET
import retrofit2.http.Query

internal interface MealsService {

    @GET("filter.php")
    suspend fun getMealsByCategory(@Query("c") category: String): MealsResponse

    @GET("filter.php")
    suspend fun getMealsByIngredient(@Query("i") ingredient: String): MealsResponse

    @GET("filter.php")
    suspend fun getMealsByArea(@Query("a") area: String): MealsResponse

    @GET("lookup.php")
    suspend fun getMealDetails(@Query("i") id: String): MealDetailsResponse
}