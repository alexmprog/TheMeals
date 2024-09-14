# TheMeals

![GitHub Logo](/screenshots/meals_app_flow.gif)

## About
It simply loads data from API and stores it in persistence storage (i.e. SQLite Database). Data will be always loaded from local database. Remote data (from API) and Local data is always synchronized.
* User real [TheMealDB](https://www.themealdb.com/) api.<br>
* This makes it offline capable.<br>
* Clean and Simple Material UI.<br>
* Use convention plugins.<br>
* Use multi-module Gradle architecture.<br>

## Built With 🛠
[Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.<br>
[Kotlin Gradle DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - Provides an alternative syntax to the traditional Groovy DSL for Gradle build system. <br>
[Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..<br>
[Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) - A cold asynchronous data stream that sequentially emits values and completes normally or with an exception.<br>
[Compose](https://developer.android.com/develop/ui/compose/documentation) - The modern toolkit for building native Android UI.<br>
[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.<br>
[Jetpack Navigation](https://developer.android.com/guide/navigation) - Component helps you implement navigation.<br>
[Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library.<br>
[Koin]([https://dagger.dev/](https://insert-koin.io) - The pragmatic Kotlin Dependency Injection framework.<br>
[Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.<br>
[Kotlin Serialization]([https://github.com/square/moshi](https://kotlinlang.org/docs/serialization.html)) - A modern JSON library for Kotlin and Java.<br>
[MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver) - A scriptable web server for testing HTTP clients.<br>
[Testing](https://developer.android.com/training/testing) - App contains different kinds of tests: Local Unit, Integration, UI, End2End tests.<br>
## Architecture
This app uses [Clean architecture](http://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) and [MVVM](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) for Presentation level.
![Image of Clean architecture](https://habrastorage.org/web/986/9db/e34/9869dbe34b5649e28be40bff6bee3147.png)
![Image of MVVM](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)
