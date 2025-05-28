package com.hannes.starwars.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.hannes.starwars.data.model.crossref.FilmPlanetCrossRef

data class FilmWithPlanets(
    @Embedded
    val film: Film,
    @Relation(
        parentColumn = "filmId",
        entityColumn = "planetId",
        associateBy = Junction(FilmPlanetCrossRef::class)
    )
    val planets: List<Planet>
)

/*
data class PlaylistWithSongs(
   @Embedded val playlist: Playlist,
   @Relation(
       parentColumn = "playlistId",
       entityColumn = "songId",
       associateBy = Junction(SongPlaylistCrossRef::class)
   )
   val songs: List<Song>
)

 */