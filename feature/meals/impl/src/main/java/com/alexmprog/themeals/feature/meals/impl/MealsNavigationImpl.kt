package com.alexmprog.themeals.feature.meals.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.feature.meals.api.MealsListScreenRoute
import com.alexmprog.themeals.feature.meals.impl.presentation.MealsListScreen
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Single
@Named("MealsNavigation")
class MealsNavigation : FeatureNavigation {

    override fun build(graphBuilder: NavGraphBuilder, navController: NavHostController) =
        with(graphBuilder) {
            composable<MealsListScreenRoute> {
                MealsListScreen(onMealClick = {})
            }
        }

}