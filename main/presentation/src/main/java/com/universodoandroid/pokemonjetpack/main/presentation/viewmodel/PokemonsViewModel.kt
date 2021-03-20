package com.universodoandroid.pokemonjetpack.main.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.mvvmredux.core.BaseViewModel
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.core.reducer.Reducer
import com.universodoandroid.pokemonjetpack.main.domain.usecase.GetPokemonsUseCase
import com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.reducer.PokemonsEvent
import com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.reducer.PokemonsState
import com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.reducer.PokemonsStateEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonsViewModel(
    event: SingleLiveEvent<PokemonsEvent>,
    reducer: Reducer<PokemonsState, PokemonsStateEvent>,
    private val getPokemonsUseCase: GetPokemonsUseCase
) : BaseViewModel<PokemonsState, PokemonsEvent, PokemonsStateEvent>(event, reducer) {

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        viewModelScope.launch {
            try {
                val pokemons = getPokemonsUseCase.invoke()
                updateTo(PokemonsStateEvent.ShowPokemons(pokemons))
            } catch (e: Exception) {

            }
        }
    }

    fun openDetails(id: String) {
        sendEvent(PokemonsEvent.OpenDetails(id))
    }
}