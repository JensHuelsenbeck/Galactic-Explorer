package com.hannes.starwars.data.repository.CharacterRepo

import com.hannes.starwars.data.local.model.CharacterEntity
import com.hannes.starwars.data.model.Character
import com.hannes.starwars.data.model.Planet
import com.hannes.starwars.data.remote.ApiService


class CharacterRepository(
    private val apiService: ApiService
) : CharacterRepositoryInterface {
    override suspend fun getCharacters(): List<Character> {
        val response = apiService.getAllCharacters()
        if (response.isSuccessful) {
            return response.body()?.results ?: emptyList()
        } else {
            throw Exception("API Error: ${response.code()}")
        }
    }

    override suspend fun createCharacterEntity(character: Character): CharacterEntity {
        val characterEntity = CharacterEntity(
            characterName = character.name,
            height = character.height,
            mass = character.mass,
            hair_color = character.hair_color,
            eye_color = character.eye_color,
            birth_year = character.birth_year,
            gender = character.gender,
            homeworld = character.homeworld,
            url = character.url,
            skin_color = character.skin_color,
            characterImage = ""
        )
        return characterEntity
    }

}