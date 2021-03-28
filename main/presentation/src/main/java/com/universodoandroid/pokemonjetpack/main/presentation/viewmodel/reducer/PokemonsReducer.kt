package com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.reducer

import com.mvvmredux.core.reducer.ReducerScope

internal class PokemonsReducer : ReducerScope<PokemonsState, PokemonsStateEvent>(
    initialState = PokemonsState()
) {

    override fun updateTo(stateEvent: PokemonsStateEvent) {
        updateState {
            when (stateEvent) {
                is PokemonsStateEvent.ShowPokemons -> copy(pokemons = stateEvent.pokemons)
            }
        }
    }
}