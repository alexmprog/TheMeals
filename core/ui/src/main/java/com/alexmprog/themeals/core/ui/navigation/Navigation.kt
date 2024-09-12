package com.alexmprog.themeals.core.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureNavigation {

    fun build(graphBuilder: NavGraphBuilder, navController: NavHostController)
}