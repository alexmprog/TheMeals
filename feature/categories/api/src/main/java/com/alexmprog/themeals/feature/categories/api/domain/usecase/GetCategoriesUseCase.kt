package com.alexmprog.themeals.feature.categories.api.domain.usecase

import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.categories.api.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface GetCategoriesUseCase {
    operator fun invoke(): Flow<Resource<List<Category>>>
}