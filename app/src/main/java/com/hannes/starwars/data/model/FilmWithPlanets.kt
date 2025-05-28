package com.hannes.starwars.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

/*
data class FilmWithPlanets(
    @Embedded val film: Film,
    @Relation(
        parentColumn = "filmId",
        entityColumn = "planetId",
        associateBy = Junction(FilmPlanetCrossRef::class)
    )
)

 */
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