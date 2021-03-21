package com.universodoandroid.pokemonjetpack.main.domain.usecase

import com.universodoandroid.pokemonjetpack.main.domain.entity.Pokemon
import kotlinx.coroutines.flow.Flow

interface GetPokemonsUseCase {
    operator fun invoke(): Flow<List<Pokemon>>
}