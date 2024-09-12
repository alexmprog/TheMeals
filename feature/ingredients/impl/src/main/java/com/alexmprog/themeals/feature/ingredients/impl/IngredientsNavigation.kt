package com.alexmprog.themeals.feature.ingredients.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alexmprog.themeals.core.ui.navigation.NavigationRouteBuilder
import com.alexmprog.themeals.feature.ingredients.api.IngredientsListScreen
import com.alexmprog.themeals.feature.ingredients.impl.presentation.IngredientsListScreen
import com.alexmprog.themeals.feature.meals.api.MealsListScreenRoute
import com.alexmprog.themeals.feature.meals.api.domain.MealsSearchSource

class IngredientsNavigation : NavigationRouteBuilder {

    override fun NavGraphBuilder.build(navController: NavHostController) {
        composable<IngredientsListScreen> {
            IngredientsListScreen(onIngredientClick = {
                navController.navigate(MealsListScreenRoute(it.name, MealsSearchSource.Ingredient))
            })
        }
    }
}