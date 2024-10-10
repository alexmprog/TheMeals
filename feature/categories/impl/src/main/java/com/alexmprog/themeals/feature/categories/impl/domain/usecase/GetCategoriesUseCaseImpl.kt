package com.alexmprog.themeals.feature.categories.impl.domain.usecase

import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.categories.api.domain.repository.CategoriesRepository
import com.alexmprog.themeals.feature.categories.api.domain.model.Category
import com.alexmprog.themeals.feature.categories.api.domain.usecase.GetCategoriesUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetCategoriesUseCaseImpl @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) : GetCategoriesUseCase {
    override operator fun invoke(): Flow<Resource<List<Category>>> =
        categoriesRepository.getCategories()
}