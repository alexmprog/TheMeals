package com.alexmprog.themeals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.core.ui.theme.TheMealsTheme
import com.alexmprog.themeals.feature.categories.api.CategoriesListScreenRoute
import com.alexmprog.themeals.inject.KoinInjectProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinInjectProvider { features: List<FeatureNavigation> ->
                TheMealsTheme {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = CategoriesListScreenRoute) {
                        features.forEach { feature -> feature.build(this, navController) }
                    }
                }
            }
        }
    }
}