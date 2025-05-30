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
            characterName = character.name.lowercase(),
            height = character.height.lowercase(),
            mass = character.mass.lowercase(),
            hair_color = character.hair_color.lowercase(),
            eye_color = character.eye_color.lowercase(),
            birth_year = character.birth_year.lowercase(),
            gender = character.gender.lowercase(),
            homeworld = character.homeworld.lowercase(),
            url = character.url,
            skin_color = character.skin_color.lowercase(),
            characterImage = ""
        )
        return characterEntity
    }

}