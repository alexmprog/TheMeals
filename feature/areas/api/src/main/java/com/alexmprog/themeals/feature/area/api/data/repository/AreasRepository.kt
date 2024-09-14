package com.alexmprog.themeals.feature.area.api.data.repository

import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.area.api.domain.model.Area
import kotlinx.coroutines.flow.Flow

interface AreasRepository {

    fun getAreas(): Flow<Resource<List<Area>>>
}