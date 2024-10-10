package com.alexmprog.themeals.feature.areas.impl

import com.alexmprog.themeals.feature.area.api.AreasListScreenRoute
import com.alexmprog.themeals.feature.areas.impl.presentation.AreasListScreen
import com.alexmprog.themeals.feature.meals.api.MealsListScreenRoute
import com.alexmprog.themeals.feature.meals.api.domain.model.MealsSearchSource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Single
@Named("AreasNavigation")
class AreasNavigation : FeatureNavigation {

    override fun registerGraph(graphBuilder: NavGraphBuilder, navController: NavHostController) =
        with(graphBuilder) {
            composable<AreasListScreenRoute> {
                AreasListScreen {
                    navController.navigate(
                        MealsListScreenRoute(it.name, MealsSearchSource.Area)
                    )
                }
            }
        }
}