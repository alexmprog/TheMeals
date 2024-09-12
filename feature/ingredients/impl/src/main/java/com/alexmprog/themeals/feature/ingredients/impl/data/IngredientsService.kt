package com.alexmprog.themeals.feature.ingredients.impl.data

import retrofit2.http.GET

internal interface IngredientsService {

    @GET("list.php?c=list")
    suspend fun getIngredients(): IngredientsResponse
}