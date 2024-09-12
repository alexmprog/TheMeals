package com.alexmprog.themeals.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexmprog.themeals.core.database.dao.CategoryDao
import com.alexmprog.themeals.core.database.dao.AreaDao
import com.alexmprog.themeals.core.database.dao.IngredientDao
import com.alexmprog.themeals.core.database.model.AreaEntity
import com.alexmprog.themeals.core.database.model.CategoryEntity
import com.alexmprog.themeals.core.database.model.IngredientEntity

@Database(
    entities = [
        CategoryEntity::class,
        IngredientEntity::class,
        AreaEntity::class
    ],
    version = 1,
    autoMigrations = [],
    exportSchema = true,
)
internal abstract class MealsDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    abstract fun ingredientDao(): IngredientDao

    abstract fun areaDao(): AreaDao
}