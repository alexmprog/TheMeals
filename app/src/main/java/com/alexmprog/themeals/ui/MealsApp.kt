package com.alexmprog.themeals.ui

import androidx.annotation.StringRes
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alexmprog.themeals.R
import com.alexmprog.themeals.feature.categories.api.CategoriesListScreenRoute
import com.alexmprog.themeals.feature.ingredients.api.IngredientsListScreenRoute
import com.alexmprog.themeals.feature.meals.api.MealsListScreenRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MealsApp(appState: MealsAppState) {
    val navController = appState.navController
    val navItems = remember {
        listOf(
            NavItem(
                titleRes = R.string.categories,
                screenRoute = CategoriesListScreenRoute,
                selectedIcon = Icons.Filled.Search,
                unselectedIcon = Icons.Outlined.Search
            ), NavItem(
                titleRes = R.string.ingredients,
                screenRoute = IngredientsListScreenRoute,
                selectedIcon = Icons.Filled.Info,
                unselectedIcon = Icons.Outlined.Info
            )
        )
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            getTitle(currentDestination)?.let {
                TopAppBar(title = { Text(stringResource(it)) })
            }
        },
        bottomBar = {
            navItems.firstOrNull {
                currentDestination?.hasRoute(it.screenRoute::class) == true
            }?.let {
                MainNavigationBar(navItems, navController)
            }
        }
    )
    { innerPadding ->
        NavHost(navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            startDestination = CategoriesListScreenRoute,
            enterTransition = { fadeIn() },
            popEnterTransition = { fadeIn() },
            exitTransition = { fadeOut() },
            popExitTransition = { fadeOut() }) {
            appState.features.forEach { feature -> feature.build(this, navController) }
        }
    }
}

@Composable
private fun MainNavigationBar(navItems: List<NavItem>, navHostController: NavHostController) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    navHostController.navigate(item.screenRoute) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (selectedTabIndex == index) item.selectedIcon
                        else item.unselectedIcon,
                        contentDescription = stringResource(item.titleRes)
                    )
                },
                label = { Text(stringResource(item.titleRes)) })
        }
    }
}

@StringRes
private fun getTitle(destination: NavDestination?): Int? = destination?.let {
    return when {
        destination.hasRoute<CategoriesListScreenRoute>() -> R.string.categories
        destination.hasRoute<IngredientsListScreenRoute>() -> R.string.ingredients
        destination.hasRoute<MealsListScreenRoute>() -> R.string.meals
        else -> null
    }
} ?: run { null }

private data class NavItem(
    @StringRes
    val titleRes: Int,
    val screenRoute: Any,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)