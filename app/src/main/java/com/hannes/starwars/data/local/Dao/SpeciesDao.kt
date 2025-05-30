package com.hannes.starwars.data.local.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hannes.starwars.data.local.model.SpeciesEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface SpeciesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(species: SpeciesEntity)

    @Query("SELECT * from species ORDER BY speciesName ASC")
    fun getAllISpecies(): Flow<List<SpeciesEntity>>

    @Delete
    suspend fun delete(species: SpeciesEntity)

    @Update
    suspend fun update(species: SpeciesEntity)
}

