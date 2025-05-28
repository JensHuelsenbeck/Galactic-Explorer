package com.hannes.starwars.data.repository.CharacterRepo

import com.hannes.starwars.data.model.Character
import com.hannes.starwars.data.model.Planet

interface CharacterRepositoryInterface {
    suspend fun getCharacters(): List<Character>
}