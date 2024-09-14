package com.alexmprog.themeals.feature.area.api.domain.usecase

import com.alexmprog.themeals.feature.area.api.domain.model.Area
import com.alexmprog.themeals.core.common.model.Resource
import kotlinx.coroutines.flow.Flow

interface GetAreasUseCase {
    operator fun invoke(): Flow<Resource<List<Area>>>
}