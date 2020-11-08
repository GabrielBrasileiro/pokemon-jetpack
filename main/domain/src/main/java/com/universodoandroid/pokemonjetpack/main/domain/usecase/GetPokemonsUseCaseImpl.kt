package com.universodoandroid.pokemonjetpack.main.domain.usecase

import com.universodoandroid.pokemonjetpack.main.domain.entity.Pokemon
import com.universodoandroid.pokemonjetpack.main.domain.repository.PokemonsRepository

internal class GetPokemonsUseCaseImpl(
    private val pokemonsRepository: PokemonsRepository
) : GetPokemonsUseCase {

    override suspend fun invoke(): List<Pokemon> {
        return pokemonsRepository.getPokemons()
    }
}