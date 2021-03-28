package com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.reducer

import com.mvvmredux.core.state.State
import com.universodoandroid.pokemonjetpack.main.domain.entity.Pokemon

data class PokemonsState(
    val pokemons: List<Pokemon> = listOf()
) : State