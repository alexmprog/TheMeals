plugins {
    alias(libs.plugins.convention.jvm.library)
    alias(libs.plugins.convention.koin)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}