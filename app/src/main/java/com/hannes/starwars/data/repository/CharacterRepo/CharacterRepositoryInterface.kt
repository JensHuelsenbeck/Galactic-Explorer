package com.hannes.starwars.data.repository.CharacterRepo

import com.hannes.starwars.data.local.model.CharacterEntity
import com.hannes.starwars.data.model.Character

interface CharacterRepositoryInterface {
    suspend fun getCharacters(): List<Character>
    suspend fun createCharacterEntity(character: Character): CharacterEntity
}