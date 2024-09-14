package com.alexmprog.themeals.feature.categories.impl.data.repository

import com.alexmprog.themeals.core.common.dispatcher.CommonIoDispatcher
import com.alexmprog.themeals.core.common.model.ErrorType
import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.core.database.dao.CategoryDao
import com.alexmprog.themeals.core.database.model.CategoryEntity
import com.alexmprog.themeals.feature.categories.api.data.repository.CategoriesRepository
import com.alexmprog.themeals.feature.categories.api.domain.model.Category
import com.alexmprog.themeals.feature.categories.impl.data.network.CategoriesService
import com.alexmprog.themeals.feature.categories.impl.data.network.CategoryDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Single
internal class CategoriesRepositoryImpl(
    private val categoryDao: CategoryDao,
    private val categoriesService: CategoriesService,
    @Named(CommonIoDispatcher) private val dispatcher: CoroutineDispatcher
) : CategoriesRepository {

    override fun getCategories(): Flow<Resource<List<Category>>> = flow {
        val localFlow = categoryDao.getCategoryEntities()
        runCatching {
            categoryDao.saveCategoryEntities(
                categoriesService.getCategories().categories.map { it.toEntity() }
            )
        }.onSuccess {
            emit(localFlow.first())
        }.onFailure {
            val localData = localFlow.firstOrNull()
            if (!localData.isNullOrEmpty()) emit(localData) else throw it
        }
    }.map { it -> Resource.Success(it.map { it.toModel() }) as Resource<List<Category>> }
        .catch { emit(Resource.Error(ErrorType.Network)) }
        .flowOn(dispatcher)

}

internal fun CategoryDTO.toEntity(): CategoryEntity = CategoryEntity(name)

internal fun CategoryEntity.toModel(): Category = Category(name)