package com.alexmprog.themeals.feature.ingredients.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.feature.ingredients.api.IngredientsListScreenRoute
import com.alexmprog.themeals.feature.ingredients.impl.presentation.IngredientsListScreen
import com.alexmprog.themeals.feature.meals.api.MealsListScreenRoute
import com.alexmprog.themeals.feature.meals.api.domain.model.MealsSearchSource
import javax.inject.Inject

internal class IngredientsNavigation @Inject constructor() : FeatureNavigation {

    override fun registerGraph(graphBuilder: NavGraphBuilder, navController: NavHostController) =
        with(graphBuilder) {
            composable<IngredientsListScreenRoute> {
                IngredientsListScreen(onIngredientClick = {
                    navController.navigate(
                        MealsListScreenRoute(it.name, MealsSearchSource.Ingredient)
                    )
                })
            }
        }
}