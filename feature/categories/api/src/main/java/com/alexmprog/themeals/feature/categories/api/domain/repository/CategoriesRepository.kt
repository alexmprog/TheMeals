package com.alexmprog.themeals.feature.categories.api.domain.repository

import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.categories.api.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {

    fun getCategories(): Flow<Resource<List<Category>>>
}