package com.alexmprog.themeals.feature.meals.impl.data

import com.alexmprog.themeals.core.common.model.ErrorType
import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.feature.meals.api.domain.Meal
import com.alexmprog.themeals.feature.meals.api.domain.MealDetails
import com.alexmprog.themeals.feature.meals.api.domain.MealsRepository
import com.alexmprog.themeals.feature.meals.api.domain.MealsSearchSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Single
internal class MealsRepositoryImpl(
    private val mealsService: MealsService,
    @Named("IoDispatcher") private val dispatcher: CoroutineDispatcher
) : MealsRepository {

    override fun getMealsBySource(
        id: String,
        source: MealsSearchSource
    ): Flow<Resource<List<Meal>>> = flow {
        emit(
            when (source) {
                MealsSearchSource.Category -> mealsService.getMealsByCategory(id).meals
                MealsSearchSource.Ingredient -> mealsService.getMealsByIngredient(id).meals
                MealsSearchSource.Area -> mealsService.getMealsByArea(id).meals
            }
        )
    }.map { Resource.Success(it.map { it.toModel() }) as Resource<List<Meal>> }
        .catch { emit(Resource.Error(ErrorType.Network)) }
        .flowOn(dispatcher)

    override fun getMealDetails(id: Int): Flow<Resource<MealDetails>> = emptyFlow()

}

internal fun MealDTO.toModel(): Meal = Meal(id, name, image)

internal fun MealDetailsDTO.toModel(): MealDetails {
    val ingredients = mutableListOf<String>()
    ingredient1?.let { ingredients.add(it) }
    ingredient2?.let { ingredients.add(it) }
    ingredient3?.let { ingredients.add(it) }
    ingredient4?.let { ingredients.add(it) }
    ingredient5?.let { ingredients.add(it) }
    ingredient6?.let { ingredients.add(it) }
    ingredient7?.let { ingredients.add(it) }
    ingredient8?.let { ingredients.add(it) }
    ingredient9?.let { ingredients.add(it) }
    ingredient10?.let { ingredients.add(it) }
    ingredient11?.let { ingredients.add(it) }
    ingredient12?.let { ingredients.add(it) }
    ingredient13?.let { ingredients.add(it) }
    ingredient14?.let { ingredients.add(it) }
    ingredient15?.let { ingredients.add(it) }
    ingredient16?.let { ingredients.add(it) }
    ingredient17?.let { ingredients.add(it) }
    ingredient18?.let { ingredients.add(it) }
    ingredient19?.let { ingredients.add(it) }
    ingredient20?.let { ingredients.add(it) }
    return MealDetails(id, category, area, description ?: "", ingredients)
}