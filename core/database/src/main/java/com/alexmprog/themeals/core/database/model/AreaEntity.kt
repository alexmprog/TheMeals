package com.alexmprog.themeals.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Area")
data class AreaEntity(
    @PrimaryKey
    val name: String
)