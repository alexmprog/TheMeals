package com.alexmprog.themeals.feature.categories.impl.di

import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.feature.categories.impl.CategoriesNavigation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@InstallIn(SingletonComponent::class)
@Module
internal interface CategoriesFeatureModule {

    @Binds
    @IntoSet
    fun bindCategoriesFeatureNavigation(impl: CategoriesNavigation): FeatureNavigation
}