package com.hannes.starwars.data.remote.model

import com.hannes.starwars.data.model.Character

class CharacterResponse (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Character>
)