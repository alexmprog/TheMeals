package com.alexmprog.themeals.feature.areas.impl.data.network

import retrofit2.http.GET

internal interface AreasService {

    @GET("list.php?a=list")
    suspend fun getAreas(): AreasResponse
}