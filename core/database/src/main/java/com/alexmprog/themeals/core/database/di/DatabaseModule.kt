package com.alexmprog.themeals.core.database.di

import android.content.Context
import androidx.room.Room
import com.alexmprog.themeals.core.database.MealsDatabase
import com.alexmprog.themeals.core.database.dao.AreaDao
import com.alexmprog.themeals.core.database.dao.CategoryDao
import com.alexmprog.themeals.core.database.dao.IngredientDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun providesMealsDatabase(@ApplicationContext context: Context): MealsDatabase =
        Room.databaseBuilder(
            context,
            MealsDatabase::class.java,
            "meals-database",
        ).build()

    @Provides
    fun providesCategoryDao(database: MealsDatabase): CategoryDao = database.categoryDao()

    @Provides
    fun providesIngredientDao(database: MealsDatabase): IngredientDao =
        database.ingredientDao()

    @Provides
    fun providesAreaDao(database: MealsDatabase): AreaDao = database.areaDao()
}