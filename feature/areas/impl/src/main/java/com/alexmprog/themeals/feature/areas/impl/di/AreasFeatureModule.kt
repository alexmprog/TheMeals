package com.alexmprog.themeals.feature.areas.impl.di

import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.feature.areas.impl.AreasNavigation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@InstallIn(SingletonComponent::class)
@Module
internal interface AreasFeatureModule {

    @Binds
    @IntoSet
    fun bindAreasFeatureNavigation(impl: AreasNavigation): FeatureNavigation
}