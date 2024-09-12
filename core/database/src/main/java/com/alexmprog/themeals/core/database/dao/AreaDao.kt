package com.alexmprog.themeals.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexmprog.themeals.core.database.model.AreaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AreaDao {

    @Query(value = "SELECT * FROM Area")
    fun getAreaEntities(): Flow<List<AreaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAreaEntities(areaEntities: List<AreaEntity>): List<Long>
}