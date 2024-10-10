package com.alexmprog.themeals.di

import androidx.compose.runtime.Composable
import com.alexmprog.themeals.core.ui.navigation.FeatureNavigation
import org.koin.compose.KoinContext
import org.koin.compose.getKoin

@Composable
fun KoinInjectProvider(content: @Composable (List<FeatureNavigation>) -> Unit) {
    KoinContext {
        content(getKoin().getAll<FeatureNavigation>())
    }
}
