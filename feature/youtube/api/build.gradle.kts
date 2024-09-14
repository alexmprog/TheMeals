plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.serialization)
}

android {
    namespace = "com.alexmprog.themeals.feature.youtube.api"
}

dependencies {
    implementation(projects.core.common)
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.junit)
}