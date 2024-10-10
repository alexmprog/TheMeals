package com.alexmprog.themeals.feature.categories.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.feature.categories.api.CategoriesListScreenRoute
import com.alexmprog.themeals.feature.categories.impl.presentation.CategoriesListScreen
import com.alexmprog.themeals.feature.meals.api.MealsListScreenRoute
import com.alexmprog.themeals.feature.meals.api.domain.model.MealsSearchSource
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Single
@Named("CategoriesNavigation")
class CategoriesNavigation : FeatureNavigation {

    override fun registerGraph(graphBuilder: NavGraphBuilder, navController: NavHostController) =
        with(graphBuilder) {
            composable<CategoriesListScreenRoute> {
                CategoriesListScreen(onCategoryClick = {
                    navController.navigate(
                        MealsListScreenRoute(it.name, MealsSearchSource.Category)
                    )
                })
            }
        }
}