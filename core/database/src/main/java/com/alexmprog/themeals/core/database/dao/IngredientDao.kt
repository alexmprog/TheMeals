package com.alexmprog.themeals.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexmprog.themeals.core.database.model.IngredientEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IngredientDao {

    @Query(value = "SELECT * FROM Ingredient")
    fun getIngredientEntities(): Flow<List<IngredientEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveIngredientEntities(ingredientEntities: List<IngredientEntity>): List<Long>
}