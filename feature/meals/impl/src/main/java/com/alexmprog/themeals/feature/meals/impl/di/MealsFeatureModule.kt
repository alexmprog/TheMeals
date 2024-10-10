package com.alexmprog.themeals.feature.meals.impl.di

import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.feature.meals.impl.MealsNavigation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@InstallIn(SingletonComponent::class)
@Module
internal interface MealsFeatureModule {

    @Binds
    @IntoSet
    fun bindMealsFeatureNavigation(impl: MealsNavigation): FeatureNavigation
}