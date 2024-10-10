plugins {
    alias(libs.plugins.convention.android.library.compose)
    alias(libs.plugins.convention.hilt)
    alias(libs.plugins.convention.serialization)
}

android {
    namespace = "com.alexmprog.themeals.feature.youtube.impl"

    sourceSets {
        getByName("main") {
            java.srcDir(File("build/generated/ksp/kotlin"))
        }
    }
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.feature.youtube.api)
    implementation(libs.compose.navigation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.lifecycle.runtime.compose.android)
    implementation(libs.youtube.player)
    testImplementation(libs.junit)
}