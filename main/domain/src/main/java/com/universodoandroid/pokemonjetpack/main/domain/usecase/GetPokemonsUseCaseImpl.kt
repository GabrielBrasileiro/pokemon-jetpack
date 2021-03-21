package com.universodoandroid.pokemonjetpack.main.domain.usecase

import com.universodoandroid.pokemonjetpack.main.domain.entity.Pokemon
import com.universodoandroid.pokemonjetpack.main.domain.repository.PokemonsRepository
import kotlinx.coroutines.flow.Flow

internal class GetPokemonsUseCaseImpl(
    private val pokemonsRepository: PokemonsRepository
) : GetPokemonsUseCase {

    override fun invoke(): Flow<List<Pokemon>> {
        return pokemonsRepository.getPokemons()
    }
}