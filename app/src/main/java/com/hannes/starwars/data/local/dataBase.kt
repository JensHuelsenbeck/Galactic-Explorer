package com.hannes.starwars.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room
import com.hannes.starwars.data.local.Dao.CharacterDao
import com.hannes.starwars.data.local.Dao.FilmDao
import com.hannes.starwars.data.local.Dao.PlanetDao
import com.hannes.starwars.data.local.Dao.SpeciesDao
import com.hannes.starwars.data.local.model.FilmEntity
import com.hannes.starwars.data.local.model.PlanetEntity
import com.hannes.starwars.data.local.model.CharacterEntity
import com.hannes.starwars.data.local.model.SpeciesEntity

@Database(entities = [FilmEntity::class, PlanetEntity::class, CharacterEntity::class, SpeciesEntity::class], version = 1, exportSchema = false)
abstract class StarWarsDataBase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
    abstract fun planetDao(): PlanetDao
    abstract fun characterDao(): CharacterDao
    abstract fun speciesDao(): SpeciesDao


    companion object {
        @Volatile
        private var Instance: StarWarsDataBase? = null

        fun getDatabase(context: Context): StarWarsDataBase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, StarWarsDataBase::class.java, "starwars_database")
                    .build().also { Instance = it }
            }
        }
    }
}
