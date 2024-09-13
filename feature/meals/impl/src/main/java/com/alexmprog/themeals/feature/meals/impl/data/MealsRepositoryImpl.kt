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

    override fun getMealDetails(id: String): Flow<Resource<MealDetails>> = flow {
        emit(mealsService.getMealDetails(id).meals.first())
    }.map { Resource.Success(it.toModel()) as Resource<MealDetails> }
        .catch { emit(Resource.Error(ErrorType.Network)) }
        .flowOn(dispatcher)

}

internal fun MealDTO.toModel(): Meal = Meal(id, name, image)

internal fun MealDetailsDTO.toModel(): MealDetails {
    val ingredients = mutableListOf<Pair<String, String>>()
    val addMeasuredIngredient: (String?, String?) -> Unit = { ingredient, measure ->
        if (!ingredient.isNullOrEmpty() && !measure.isNullOrEmpty())
            ingredients.add(Pair(ingredient, measure))
    }
    addMeasuredIngredient(ingredient1, measure1)
    addMeasuredIngredient(ingredient2, measure2)
    addMeasuredIngredient(ingredient3, measure3)
    addMeasuredIngredient(ingredient4, measure4)
    addMeasuredIngredient(ingredient5, measure5)
    addMeasuredIngredient(ingredient6, measure6)
    addMeasuredIngredient(ingredient7, measure7)
    addMeasuredIngredient(ingredient8, measure8)
    addMeasuredIngredient(ingredient9, measure9)
    addMeasuredIngredient(ingredient10, measure10)
    addMeasuredIngredient(ingredient11, measure11)
    addMeasuredIngredient(ingredient12, measure12)
    addMeasuredIngredient(ingredient13, measure13)
    addMeasuredIngredient(ingredient14, measure14)
    addMeasuredIngredient(ingredient15, measure15)
    addMeasuredIngredient(ingredient16, measure16)
    addMeasuredIngredient(ingredient17, measure17)
    addMeasuredIngredient(ingredient18, measure18)
    addMeasuredIngredient(ingredient19, measure19)
    addMeasuredIngredient(ingredient20, measure20)
    return MealDetails(id, category, area, description ?: "", ingredients)
}