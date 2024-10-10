package com.alexmprog.themeals.feature.ingredients.impl.data.repository

import com.alexmprog.themeals.core.common.dispatcher.CommonDispatchers
import com.alexmprog.themeals.core.common.dispatcher.Dispatcher
import com.alexmprog.themeals.core.common.model.ErrorType
import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.core.database.dao.IngredientDao
import com.alexmprog.themeals.core.database.model.IngredientEntity
import com.alexmprog.themeals.feature.ingredients.api.domain.model.Ingredient
import com.alexmprog.themeals.feature.ingredients.api.domain.repository.IngredientsRepository
import com.alexmprog.themeals.feature.ingredients.impl.data.network.IngredientDTO
import com.alexmprog.themeals.feature.ingredients.impl.data.network.IngredientsService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class IngredientsRepositoryImpl @Inject constructor(
    private val ingredientDao: IngredientDao,
    private val ingredientsService: IngredientsService,
    @Dispatcher(CommonDispatchers.IO) private val dispatcher: CoroutineDispatcher
) : IngredientsRepository {

    override fun getIngredients(): Flow<Resource<List<Ingredient>>> = flow {
        val localFlow = ingredientDao.getIngredientEntities()
        runCatching {
            ingredientDao.saveIngredientEntities(
                ingredientsService.getIngredients().ingredients.map { it.toEntity() }
            )
        }.onSuccess {
            emit(localFlow.first())
        }.onFailure {
            val localData = localFlow.firstOrNull()
            if (!localData.isNullOrEmpty()) emit(localData) else throw it
        }
    }.map { it -> Resource.Success(it.map { it.toModel() }) as Resource<List<Ingredient>> }
        .catch { emit(Resource.Error(ErrorType.Network)) }
        .flowOn(dispatcher)
}

internal fun IngredientDTO.toEntity(): IngredientEntity = IngredientEntity(name, null)

internal fun IngredientEntity.toModel(): Ingredient = Ingredient(name, image)