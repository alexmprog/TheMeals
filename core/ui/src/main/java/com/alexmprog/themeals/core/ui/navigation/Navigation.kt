package com.alexmprog.themeals.core.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface NavigationRouteBuilder {

    fun NavGraphBuilder.build(navController: NavHostController)
}