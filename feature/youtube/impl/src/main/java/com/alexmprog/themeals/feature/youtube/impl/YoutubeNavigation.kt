package com.alexmprog.themeals.feature.youtube.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.feature.youtube.api.YoutubeScreenRoute
import com.alexmprog.themeals.feature.youtube.impl.presentation.YoutubePlayerScreen
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Single
@Named("YoutubeNavigation")
class YoutubeNavigation : FeatureNavigation {

    override fun registerGraph(graphBuilder: NavGraphBuilder, navController: NavHostController) =
        with(graphBuilder) {
            composable<YoutubeScreenRoute> { backStackEntry ->
                val route = backStackEntry.toRoute<YoutubeScreenRoute>()
                YoutubePlayerScreen(route.url)
            }
        }
}