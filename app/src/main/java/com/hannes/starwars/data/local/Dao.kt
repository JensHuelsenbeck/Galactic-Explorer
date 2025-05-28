package com.hannes.starwars.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hannes.starwars.data.model.CharacterEntity
import com.hannes.starwars.data.model.FilmEntity
import com.hannes.starwars.data.model.PlanetEntity
import com.hannes.starwars.data.model.SpeciesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(film: FilmEntity)

    @Query("SELECT * from films ORDER BY episode_id ASC")
    fun getAllIFilms(): Flow<List<FilmEntity>>

    @Delete
    suspend fun delete(film: FilmEntity)

    @Update
    suspend fun update(film: FilmEntity)


}

@Dao
interface PlanetDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(planet: PlanetEntity)

    @Query("SELECT * from planets ORDER BY name ASC")
    fun getAllIPlanets(): Flow<List<PlanetEntity>>

    @Delete
    suspend fun delete(planet: PlanetEntity)

    @Update
    suspend fun update(planet: PlanetEntity)
}

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(character: CharacterEntity)

    @Query("SELECT * from characters ORDER BY name ASC")
    fun getAllICharacters(): Flow<List<CharacterEntity>>

    @Delete
    suspend fun delete(character: CharacterEntity)

    @Update
    suspend fun update(character: CharacterEntity)
}

@Dao
interface SpeciesDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(species: SpeciesEntity)

    @Query("SELECT * from species ORDER BY name ASC")
    fun getAllISpecies(): Flow<List<SpeciesEntity>>

    @Delete
    suspend fun delete(species: SpeciesEntity)

    @Update
    suspend fun update(species: SpeciesEntity)
}


