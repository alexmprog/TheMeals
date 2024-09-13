package com.alexmprog.themeals.feature.youtube

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.feature.youtube.presentation.YoutubePlayerScreen
import kotlinx.serialization.Serializable
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Serializable
data class YoutubeScreenRoute(val url: String)

@Single
@Named("YoutubeNavigation")
class YoutubeNavigation : FeatureNavigation {

    override fun build(graphBuilder: NavGraphBuilder, navController: NavHostController) =
        with(graphBuilder) {
            composable<YoutubeScreenRoute> { backStackEntry ->
                val route = backStackEntry.toRoute<YoutubeScreenRoute>()
                YoutubePlayerScreen(route.url)
            }
        }
}