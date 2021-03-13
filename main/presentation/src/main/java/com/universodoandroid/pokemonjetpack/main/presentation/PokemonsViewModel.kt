package com.universodoandroid.pokemonjetpack.main.presentation

import androidx.lifecycle.viewModelScope
import com.mvvmredux.core.BaseViewModel
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.core.reducer.Reducer
import com.mvvmredux.core.state.StateViewModel
import com.universodoandroid.pokemonjetpack.main.domain.usecase.GetPokemonsUseCase
import com.universodoandroid.pokemonjetpack.main.presentation.reducer.PokemonsEvent
import com.universodoandroid.pokemonjetpack.main.presentation.reducer.PokemonsState
import com.universodoandroid.pokemonjetpack.main.presentation.reducer.PokemonsStateEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class PokemonsViewModel(
    event: SingleLiveEvent<PokemonsEvent>,
    reducer: Reducer<PokemonsState, PokemonsStateEvent>,
    private val getPokemonsUseCase: GetPokemonsUseCase
) : BaseViewModel<PokemonsState, PokemonsEvent, PokemonsStateEvent>(event, reducer) {

    init {
        loadPokemons()
    }

    fun loadPokemons() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                launch {
                    try {
                        val pokemons = getPokemonsUseCase.invoke()
                    } catch (e: Exception) {

                    }
                }
            }
        }
    }

    fun showInStart() {
        (PokemonsEvent.ShowInStart)
    }
}