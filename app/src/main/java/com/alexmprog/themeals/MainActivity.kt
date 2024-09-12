package com.alexmprog.themeals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.core.ui.theme.TheMealsTheme
import com.alexmprog.themeals.inject.KoinInjectProvider
import com.alexmprog.themeals.ui.MealsApp
import com.alexmprog.themeals.ui.rememberMealsAppState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinInjectProvider { features: List<FeatureNavigation> ->
                TheMealsTheme {
                    val appState = rememberMealsAppState(features = features)
                    MealsApp(appState)
                }
            }
        }
    }
}