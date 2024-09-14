package com.alexmprog.themeals.feature.categories.impl.domain.usecase

import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.categories.api.data.repository.CategoriesRepository
import com.alexmprog.themeals.feature.categories.api.domain.model.Category
import com.alexmprog.themeals.feature.categories.api.domain.usecase.GetCategoriesUseCase
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
internal class GetCategoriesUseCaseImpl(
    private val categoriesRepository: CategoriesRepository
) : GetCategoriesUseCase {
    override operator fun invoke(): Flow<Resource<List<Category>>> =
        categoriesRepository.getCategories()
}