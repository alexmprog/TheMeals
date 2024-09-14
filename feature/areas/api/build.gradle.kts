plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.serialization)
}

android {
    namespace = "com.alexmprog.themeals.feature.areas.api"
}

dependencies {
    implementation(projects.core.common)
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.junit)
}