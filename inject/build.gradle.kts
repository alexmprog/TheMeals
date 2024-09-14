plugins {
    alias(libs.plugins.convention.android.library.compose)
    alias(libs.plugins.convention.koin)
    alias(libs.plugins.convention.serialization)
}

android {
    namespace = "com.alexmprog.themeals.inject"
}

dependencies {
    implementation(projects.core.network)
    implementation(projects.core.database)
    implementation(projects.core.common)
    implementation(projects.core.ui)
    implementation(projects.feature.areas.impl)
    implementation(projects.feature.categories.impl)
    implementation(projects.feature.ingredients.impl)
    implementation(projects.feature.meals.impl)
    implementation(projects.feature.youtube.impl)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.koin.android.compose)
    testImplementation(libs.junit)
}