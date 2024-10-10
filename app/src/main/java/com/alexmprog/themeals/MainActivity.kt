package com.alexmprog.themeals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.core.ui.theme.TheMealsTheme
import com.alexmprog.themeals.ui.MealsApp
import com.alexmprog.themeals.ui.rememberMealsAppState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var featureProvider: Set<@JvmSuppressWildcards FeatureNavigation>

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheMealsTheme {
                val appState = rememberMealsAppState(features = featureProvider)
                MealsApp(appState)
            }
        }
    }
}