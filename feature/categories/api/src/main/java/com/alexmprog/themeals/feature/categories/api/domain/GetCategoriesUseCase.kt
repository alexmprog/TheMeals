package com.alexmprog.themeals.feature.categories.api.domain

import com.alexmprog.themeals.core.common.model.Resource
import kotlinx.coroutines.flow.Flow

class GetCategoriesUseCase(
    private val categoriesRepository: CategoriesRepository
) {
    operator fun invoke(): Flow<Resource<List<Category>>> = categoriesRepository.getCategories()
}