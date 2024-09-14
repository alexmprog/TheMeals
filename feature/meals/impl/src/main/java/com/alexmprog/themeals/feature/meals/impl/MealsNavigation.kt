package com.alexmprog.themeals.feature.meals.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.feature.meals.api.MealDetailsScreenRoute
import com.alexmprog.themeals.feature.meals.api.MealsListScreenRoute
import com.alexmprog.themeals.feature.meals.impl.presentation.details.MealsDetailsScreen
import com.alexmprog.themeals.feature.meals.impl.presentation.list.MealsListScreen
import com.alexmprog.themeals.feature.youtube.api.YoutubeScreenRoute
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Single
@Named("MealsNavigation")
class MealsNavigation : FeatureNavigation {

    override fun build(graphBuilder: NavGraphBuilder, navController: NavHostController) =
        with(graphBuilder) {
            composable<MealsListScreenRoute> {
                MealsListScreen {
                    navController.navigate(
                        MealDetailsScreenRoute(it.id, it.name, it.image)
                    )
                }
            }
            composable<MealDetailsScreenRoute> {
                MealsDetailsScreen {
                    navController.navigate(YoutubeScreenRoute(it))
                }
            }
        }

}