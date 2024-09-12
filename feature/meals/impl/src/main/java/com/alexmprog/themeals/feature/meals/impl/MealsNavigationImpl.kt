package com.alexmprog.themeals.feature.meals.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alexmprog.themeals.core.ui.navigation.NavigationRouteBuilder
import com.alexmprog.themeals.feature.meals.api.MealsListScreenRoute
import com.alexmprog.themeals.feature.meals.impl.presentation.MealsListScreen

class MealsNavigation : NavigationRouteBuilder {

    override fun NavGraphBuilder.build(navController: NavHostController) {
        composable<MealsListScreenRoute> {
            MealsListScreen(onMealClick = {

            })
        }
    }

}