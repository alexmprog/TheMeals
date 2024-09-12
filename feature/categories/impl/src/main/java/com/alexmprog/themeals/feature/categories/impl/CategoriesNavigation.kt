package com.alexmprog.themeals.feature.categories.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alexmprog.themeals.core.ui.navigation.NavigationRouteBuilder
import com.alexmprog.themeals.feature.categories.api.CategoriesListScreenRoute
import com.alexmprog.themeals.feature.categories.impl.presentation.CategoriesListScreen
import com.alexmprog.themeals.feature.meals.api.MealsListScreenRoute
import com.alexmprog.themeals.feature.meals.api.domain.MealsSearchSource

class CategoriesNavigation : NavigationRouteBuilder {

    override fun NavGraphBuilder.build(navController: NavHostController) {
        composable<CategoriesListScreenRoute> {
            CategoriesListScreen(onCategoryClick = {
                navController.navigate(MealsListScreenRoute(it.name, MealsSearchSource.Category))
            })
        }
    }

}