package com.alexmprog.themeals.feature.areas.impl.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class AreasResponse(
    @SerialName("meals")
    val areas: List<AreaDTO>
)

@Serializable
data class AreaDTO(
    @SerialName("strArea")
    val name: String
)