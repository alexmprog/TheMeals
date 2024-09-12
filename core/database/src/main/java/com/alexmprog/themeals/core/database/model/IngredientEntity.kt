package com.alexmprog.themeals.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ingredient")
data class IngredientEntity(
    @PrimaryKey
    val name: String,
    val image: String?
)