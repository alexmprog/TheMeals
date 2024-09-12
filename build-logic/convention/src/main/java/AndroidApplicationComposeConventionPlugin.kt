import com.alexmprog.thecocktails.build_logic.convention.configureAndroidCompose
import com.alexmprog.thecocktails.build_logic.convention.configureKotlinAndroid
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.application")
            apply(plugin = "org.jetbrains.kotlin.android")
            apply(plugin = "org.jetbrains.kotlin.plugin.compose")
            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    targetSdk = 34
                }
                configureKotlinAndroid(this)
                configureAndroidCompose(this)
            }
        }
    }

}