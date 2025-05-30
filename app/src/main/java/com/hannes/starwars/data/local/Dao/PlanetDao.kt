package com.hannes.starwars.data.local.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hannes.starwars.data.local.model.PlanetEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanetDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(planet: PlanetEntity)

    @Query("SELECT * from planets ORDER BY name ASC")
    fun getAllPlanets(): Flow<List<PlanetEntity>>

    @Delete
    suspend fun delete(planet: PlanetEntity)

    @Update
    suspend fun update(planet: PlanetEntity)
}
