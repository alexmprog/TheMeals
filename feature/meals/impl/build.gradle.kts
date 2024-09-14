plugins {
    alias(libs.plugins.convention.android.library.compose)
    alias(libs.plugins.convention.koin)
    alias(libs.plugins.convention.serialization)
}

android {
    namespace = "com.alexmprog.themeals.feature.meals.impl"

    sourceSets {
        getByName("main") {
            java.srcDir(File("build/generated/ksp/kotlin"))
        }
    }
}

dependencies {
    implementation(projects.core.network)
    implementation(projects.core.database)
    implementation(projects.core.common)
    implementation(projects.core.ui)
    implementation(projects.feature.meals.api)
    implementation(projects.feature.youtube.api)
    implementation(libs.androidx.lifecycle.runtime.compose.android)
    implementation(libs.koin.android.compose)
    implementation(libs.compose.navigation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.coil.kt.compose)
    testImplementation(libs.junit)
}