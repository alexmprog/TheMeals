package com.alexmprog.themeals.feature.ingredients.impl.di

import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.feature.ingredients.impl.IngredientsNavigation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@InstallIn(SingletonComponent::class)
@Module
internal interface IngredientsFeatureModule {

    @Binds
    @IntoSet
    fun bindIngredientsFeatureNavigation(impl: IngredientsNavigation): FeatureNavigation
}