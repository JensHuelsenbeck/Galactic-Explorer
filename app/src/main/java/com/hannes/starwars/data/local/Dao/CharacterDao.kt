package com.hannes.starwars.data.local.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hannes.starwars.data.local.model.CharacterEntity
import kotlinx.coroutines.flow.Flow

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