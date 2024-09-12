package com.alexmprog.themeals.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation

@Stable
class MealsAppState(
    val navController: NavHostController,
    val features: List<FeatureNavigation>
)

@Composable
fun rememberMealsAppState(
    mainNavController: NavHostController = rememberNavController(),
    features: List<FeatureNavigation>
): MealsAppState {
    return remember(mainNavController, features) {
        MealsAppState(navController = mainNavController, features = features)
    }
}