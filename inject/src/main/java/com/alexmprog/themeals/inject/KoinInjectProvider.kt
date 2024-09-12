package com.alexmprog.themeals.inject

import androidx.compose.runtime.Composable
import com.alexmprog.themeals.core.common.dispatcher.DispatchersModule
import com.alexmprog.themeals.core.common.utils.declareMultibinding
import com.alexmprog.themeals.core.common.utils.intoMultibinding
import com.alexmprog.themeals.core.database.di.DatabaseModule
import com.alexmprog.themeals.core.network.di.NetworkModule
import com.alexmprog.themeals.core.ui.navigation.NavigationRouteBuilder
import com.alexmprog.themeals.feature.categories.impl.CategoriesNavigation
import com.alexmprog.themeals.feature.categories.impl.di.CategoriesFeatureModule
import com.alexmprog.themeals.feature.ingredients.impl.IngredientsNavigation
import com.alexmprog.themeals.feature.ingredients.impl.di.IngredientsFeatureModule
import com.alexmprog.themeals.feature.meals.impl.MealsNavigation
import com.alexmprog.themeals.feature.meals.impl.di.MealsFeatureModule
import org.koin.compose.KoinApplication
import org.koin.dsl.module
import org.koin.ksp.generated.module
import kotlin.reflect.KClass

@Composable
fun KoinInjectProvider(content: @Composable () -> Unit) {
    KoinApplication({
        modules(
            // core modules
            DispatchersModule().module,
            NetworkModule().module,
            DatabaseModule().module,
            // feature modules
            CategoriesFeatureModule().module,
            IngredientsFeatureModule().module,
            MealsFeatureModule().module,
            // navigation module
            navigationModule
        )
    }) {
        content()
    }
}

val navigationModule = module {
    declareMultibinding<KClass<out NavigationRouteBuilder>, NavigationRouteBuilder>()
    intoMultibinding(CategoriesNavigation::class, CategoriesNavigation())
    intoMultibinding(IngredientsNavigation::class, IngredientsNavigation())
    intoMultibinding(MealsNavigation::class, MealsNavigation())
}
