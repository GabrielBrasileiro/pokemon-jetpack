package com.universodoandroid.pokemonjetpack.main.domain.usecase

import com.universodoandroid.pokemonjetpack.main.domain.entity.Pokemon

interface GetPokemonsUseCase {
    suspend operator fun invoke(): List<Pokemon>
}