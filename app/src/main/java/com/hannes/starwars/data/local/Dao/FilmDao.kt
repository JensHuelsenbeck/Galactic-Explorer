package com.hannes.starwars.data.local.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hannes.starwars.data.local.model.FilmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(film: FilmEntity)

    @Query("SELECT * from films ORDER BY episode_id ASC")
    fun getAllFilms(): Flow<List<FilmEntity>>

    @Delete
    suspend fun delete(film: FilmEntity)

    @Update
    suspend fun update(film: FilmEntity)



}




