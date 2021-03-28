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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
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

    private fun loadPokemons() {
        viewModelScope.launch {
            try {
                getPokemonsUseCase.invoke()
                    .flowOn(Dispatchers.IO)
                    .collect {
                        updateTo(PokemonsStateEvent.ShowPokemons(it))
                    }
            } catch (e: Exception) {
                print(e.message)
            }
        }
    }

    fun openDetails(id: String) {
        sendEvent(PokemonsEvent.OpenDetails(id))
    }
}