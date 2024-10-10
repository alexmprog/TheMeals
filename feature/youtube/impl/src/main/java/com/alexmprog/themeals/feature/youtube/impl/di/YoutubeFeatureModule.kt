package com.alexmprog.themeals.feature.youtube.impl.di

import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import com.alexmprog.themeals.feature.youtube.impl.YoutubeNavigation

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
    fun bindYoutubeFeatureNavigation(impl: YoutubeNavigation): FeatureNavigation
}