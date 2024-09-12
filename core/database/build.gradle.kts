plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.koin)
    alias(libs.plugins.room)
}

android {
    namespace = "com.alexmprog.themeals.core.database"

    buildFeatures {
        buildConfig = true
    }

    room {
        schemaDirectory("$projectDir/db_schemas")
    }
}

dependencies {
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.kotlinx.coroutines.test)
}