plugins {
    alias(libs.plugins.convention.android.application.compose)
    alias(libs.plugins.convention.hilt)
    alias(libs.plugins.convention.serialization)
}

android {
    namespace = "com.alexmprog.themeals"

    defaultConfig {
        applicationId = "com.alexmprog.themeals"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.database)
    implementation(projects.core.ui)
    implementation(projects.core.network)
    implementation(projects.feature.areas.api)
    implementation(projects.feature.areas.impl)
    implementation(projects.feature.categories.api)
    implementation(projects.feature.categories.impl)
    implementation(projects.feature.ingredients.api)
    implementation(projects.feature.ingredients.impl)
    implementation(projects.feature.meals.api)
    implementation(projects.feature.meals.impl)
    implementation(projects.feature.youtube.api)
    implementation(projects.feature.youtube.impl)
    implementation(libs.androidx.core.ktx)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.compose.navigation)
    implementation(libs.compose.hilt.navigation)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.lifecycle.runtime.compose.android)
    implementation(libs.compose.navigation)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.compose.ui.test)
    debugImplementation(libs.androidx.compose.ui.testManifest)
}