package com.alexmprog.themeals.feature.meals.api

import com.alexmprog.themeals.feature.meals.api.domain.MealsSearchSource
import kotlinx.serialization.Serializable

@Serializable
data class MealsListScreenRoute(val id: String, val source: MealsSearchSource)