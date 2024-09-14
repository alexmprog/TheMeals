package com.alexmprog.themeals.feature.ingredients.impl.data.network

import retrofit2.http.GET

internal interface IngredientsService {

    @GET("list.php?i=list")
    suspend fun getIngredients(): IngredientsResponse
}