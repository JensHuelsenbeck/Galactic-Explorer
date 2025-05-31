package com.hannes.starwars.data.repository.CharacterRepo

import com.hannes.starwars.data.local.model.CharacterEntity
import com.hannes.starwars.data.model.Character
import com.hannes.starwars.data.remote.ApiService


class CharacterRepository(
    private val apiService: ApiService
) : CharacterRepositoryInterface {
    override suspend fun getCharacters(): List<Character> {
        val allCharacters = mutableListOf<Character>()
        var currentPage = 1
        var hasNext = true

        while (hasNext) {
            val response = apiService.getCharacterByPage(currentPage)
            if (response.isSuccessful) {
                val body = response.body()
                val characters = body?.results ?: emptyList()
                allCharacters += characters
                hasNext = body?.next != null
                currentPage++
            } else {
                throw Exception("API Error on page $currentPage: ${response.code()}")
            }
        }

        return allCharacters
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