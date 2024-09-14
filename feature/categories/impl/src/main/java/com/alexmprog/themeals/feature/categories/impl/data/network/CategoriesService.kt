package com.alexmprog.themeals.feature.categories.impl.data.network

import retrofit2.http.GET

internal interface CategoriesService {

    @GET("list.php?c=list")
    suspend fun getCategories(): CategoriesResponse
}