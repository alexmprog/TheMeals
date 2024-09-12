package com.alexmprog.themeals.core.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class AreasResponse(
    @SerialName("meals")
    val glasses: List<AreaDTO>
)

@Serializable
data class AreaDTO(
    @SerialName("strArea")
    val name: String
)