plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.hilt)
    alias(libs.plugins.convention.serialization)
}

android {
    namespace = "com.alexmprog.themeals.core.network"

    defaultConfig {
        buildConfigField(
            "String",
            "API_URL",
            "\"https://www.themealdb.com/api/json/v1/1/\""
        )
    }

    testOptions {
        unitTests {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }

    sourceSets {
        getByName("main") {
            java.srcDir(File("build/generated/ksp/kotlin"))
        }
    }
}

dependencies {
    api(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.okhttp.logging.interceptor)
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.okhttp.mockwebserver)
}