package com.hannes.starwars.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hannes.starwars.data.model.Character
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.model.Planet
import com.hannes.starwars.data.model.Species
import android.content.Context
import androidx.room.Room

@Database(entities = [Film::class, Planet::class, Character::class, Species::class], version = 1, exportSchema = false)
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
