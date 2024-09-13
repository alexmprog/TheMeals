package com.alexmprog.themeals.ui

import androidx.annotation.StringRes
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alexmprog.themeals.R
import com.alexmprog.themeals.feature.categories.api.CategoriesListScreenRoute
import com.alexmprog.themeals.feature.ingredients.api.IngredientsListScreenRoute
import com.alexmprog.themeals.feature.meals.api.MealDetailsScreenRoute
import com.alexmprog.themeals.feature.meals.api.MealsListScreenRoute
import com.alexmprog.themeals.feature.youtube.YoutubeScreenRoute

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
                TopAppBar(title = { Text(stringResource(it)) },
                    navigationIcon = {
                        if (canNavigateBack(currentDestination)) {
                            IconButton(onClick = {
                                navController.navigateUp()
                            }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = null
                                )
                            }
                        }
                    })
            }
        },
        bottomBar = {
            var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
            navItems.firstOrNull { currentDestination?.hasRoute(it.screenRoute::class) == true }
                ?.let {
                    MainNavigationBar(
                        navItems,
                        selectedTabIndex,
                    ) { index, item ->
                        selectedTabIndex = index
                        navController.navigate(item.screenRoute) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
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
private fun MainNavigationBar(
    navItems: List<NavItem>,
    selectedTabIndex: Int,
    onTabSelected: (Int, NavItem) -> Unit
) {
    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index, item) },
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
        destination.hasRoute<MealDetailsScreenRoute>() -> R.string.details
        destination.hasRoute<YoutubeScreenRoute>() -> R.string.youtube
        else -> null
    }
} ?: run { null }

private fun canNavigateBack(destination: NavDestination?): Boolean = destination?.let {
    destination.hasRoute<MealsListScreenRoute>() ||
            destination.hasRoute<MealDetailsScreenRoute>() ||
            destination.hasRoute<YoutubeScreenRoute>()
} ?: run { false }

private data class NavItem(
    @StringRes
    val titleRes: Int,
    val screenRoute: Any,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)