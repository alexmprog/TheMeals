package com.alexmprog.themeals.feature.categories.api.domain

import com.alexmprog.themeals.core.common.model.Resource
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {

    fun getCategories(): Flow<Resource<List<Category>>>
}