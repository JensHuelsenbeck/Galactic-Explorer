package com.hannes.starwars.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.model.Planet
import com.hannes.starwars.data.model.Species
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(film: Film)

    @Query("SELECT * from films ORDER BY episode_id ASC")
    fun getAllIFilms(): Flow<List<Film>>

    @Delete
    suspend fun delete(film: Film)

    @Update
    suspend fun update(film: Film)
}

@Dao
interface PlanetDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(planet: Planet)

    @Query("SELECT * from planets ORDER BY name ASC")
    fun getAllIFilms(): Flow<List<Planet>>

    @Delete
    suspend fun delete(planet: Planet)

    @Update
    suspend fun update(planet: Planet)
}

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(character: Character)

    @Query("SELECT * from characters ORDER BY name ASC")
    fun getAllIFilms(): Flow<List<Planet>>

    @Delete
    suspend fun delete(character: Character)

    @Update
    suspend fun update(character: Character)
}

@Dao
interface SpeciesDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(species: Species)

    @Query("SELECT * from species ORDER BY name ASC")
    fun getAllIFilms(): Flow<List<Planet>>

    @Delete
    suspend fun delete(species: Species)

    @Update
    suspend fun update(species: Species)
}
