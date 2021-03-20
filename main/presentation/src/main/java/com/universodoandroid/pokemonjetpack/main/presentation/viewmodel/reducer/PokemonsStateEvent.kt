package com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.reducer

import com.mvvmredux.core.stateevent.StateEvent
import com.universodoandroid.pokemonjetpack.main.domain.entity.Pokemon

sealed class PokemonsStateEvent : StateEvent {

    data class ShowPokemons(val pokemons: List<Pokemon>) : PokemonsStateEvent()
}