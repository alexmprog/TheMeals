package com.alexmprog.themeals.core.database.di

import android.content.Context
import androidx.room.Room
import com.alexmprog.themeals.core.database.MealsDatabase
import com.alexmprog.themeals.core.database.dao.AreaDao
import com.alexmprog.themeals.core.database.dao.CategoryDao
import com.alexmprog.themeals.core.database.dao.IngredientDao
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
@ComponentScan
class DatabaseModule {

    @Singleton
    internal fun providesMealsDatabase(context: Context): MealsDatabase =
        Room.databaseBuilder(
            context,
            MealsDatabase::class.java,
            "meals-database",
        ).build()

    @Factory
    internal fun providesCategoryDao(database: MealsDatabase): CategoryDao = database.categoryDao()

    @Factory
    internal fun providesIngredientDao(database: MealsDatabase): IngredientDao =
        database.ingredientDao()

    @Factory
    internal fun providesGlassDao(database: MealsDatabase): AreaDao = database.areaDao()
}