# TheMeals

![GitHub Logo](/screenshots/meals_app_flow.gif)

## About
It simply loads data from API and stores it in persistence storage (i.e. SQLite Database).
* User real [TheMealDB](https://www.themealdb.com/) api.<br>
* This makes it offline capable.<br>
* Clean and Simple Compose Material UI.<br>
* Use Gradle version catalog and convention plugins.<br>
* Clean architecture and MVVM.<br>

## Built With 🛠
[Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.<br>
[Kotlin Gradle DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - Provides an alternative syntax to the traditional Groovy DSL for Gradle build system. <br>
[Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - Kotlin Asynchronous or non-blocking programming.<br>
[Compose](https://developer.android.com/develop/ui/compose/documentation) - The modern toolkit for building native Android UI.<br>
[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.<br>
[Jetpack Navigation](https://developer.android.com/guide/navigation) - Component helps you implement navigation.<br>
[Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library.<br>
[Koin](https://insert-koin.io) - The pragmatic Kotlin Dependency Injection framework.<br>
[Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.<br>
[Coil](https://coil-kt.github.io/coil/) - An image loading library for Android.<br>
[Kotlin Serialization]([https://github.com/square/moshi](https://kotlinlang.org/docs/serialization.html)) - A modern JSON library for Kotlin and Java.<br>
[Testing](https://developer.android.com/training/testing) - App contains different kinds of tests: Local Unit, Integration, UI, End2End tests.<br>

## Modules Overview
The project is divided into several modules:
- :app:mobile - Android app module for phone devices.
- :build:logic:convention - Conventions plugins for managing build configurations.
- :inject - Android library with common DI graph setup.
- :core:common - Kotlin-only module containing utility functions (not an Android library).
- :core:database - Android library with common Room database.
- :core:network - Android library with common Retrofit/Okttp network configs.
- :core:ui - Android library with common Jetpack Compose UI widgets and FeatureNavigation interface.
- :feature:categories:api - Android library with categories feature api.
- :feature:categories:impl - Android library with categories feature implementation.
- :feature:ingredients:api - Android library with ingredients feature api.
- :feature:ingredients:impl - Android library with ingredients feature implementation.
- :feature:areas:api - Android library with areas feature api.
- :feature:areas:impl - Android library with areas feature implementation.
- :feature:meals:api - Android library with meals feature api.
- :feature:meals:impl - Android library with meals feature implementation.
- :feature:youtube:api - Android library with youtube feature api.
- :feature:youtube:impl - Android library with youtube feature implementation.

## Architecture
This repository uses recommended Android [App architecture](https://developer.android.com/topic/architecture).
![Image of MVVM](https://developer.android.com/static/topic/libraries/architecture/images/mad-arch-ui-udf.png)
