package com.alexmprog.themeals.feature.categories.impl.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CategoriesResponse(
    @SerialName("meals")
    val categories: List<CategoryDTO>
)

@Serializable
data class CategoryDTO(
    @SerialName("strCategory")
    val name: String
)