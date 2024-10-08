pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "TheMeals"
include(":app")
include(":core:common")
include(":core:database")
include(":core:ui")
include(":core:network")
include(":feature:areas:api")
include(":feature:areas:impl")
include(":feature:categories:api")
include(":feature:categories:impl")
include(":feature:ingredients:api")
include(":feature:ingredients:impl")
include(":feature:meals:api")
include(":feature:meals:impl")
include(":feature:youtube:api")
include(":feature:youtube:impl")
