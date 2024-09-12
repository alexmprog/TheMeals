package com.alexmprog.themeals.inject

import android.content.Context
import com.alexmprog.themeals.core.common.dispatcher.DispatchersModule
import com.alexmprog.themeals.core.database.di.DatabaseModule
import com.alexmprog.themeals.core.network.di.NetworkModule
import com.alexmprog.themeals.feature.categories.impl.di.CategoriesFeatureModule
import com.alexmprog.themeals.feature.ingredients.impl.di.IngredientsFeatureModule
import com.alexmprog.themeals.feature.meals.impl.di.MealsFeatureModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.ksp.generated.module

fun buildGraph(context: Context) = startKoin {
    androidContext(context)
    modules(allModules())
}

internal fun allModules(): List<Module> = listOf(
    DispatchersModule().module,
    NetworkModule().module,
    DatabaseModule().module,
    CategoriesFeatureModule().module,
    IngredientsFeatureModule().module,
    MealsFeatureModule().module,
)