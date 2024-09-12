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
import com.alexmprog.themeals.core.common.utils.getMultibinding
import com.alexmprog.themeals.core.ui.navigation.NavigationRouteBuilder
import com.alexmprog.themeals.core.ui.theme.TheMealsTheme
import com.alexmprog.themeals.feature.categories.api.CategoriesListScreenRoute
import com.alexmprog.themeals.inject.KoinInjectProvider
import org.koin.android.ext.android.getKoin
import kotlin.reflect.KClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinInjectProvider {
                TheMealsTheme {
                    val routes = getKoin().getMultibinding<KClass<out NavigationRouteBuilder>, NavigationRouteBuilder>()
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = CategoriesListScreenRoute) {
                        routes.forEach{route->

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    com.alexmprog.themeals.core.ui.theme.TheMealsTheme {
        Greeting("Android")
    }
}