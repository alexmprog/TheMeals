plugins {
    alias(libs.plugins.convention.jvm.library)
    alias(libs.plugins.convention.hilt)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}