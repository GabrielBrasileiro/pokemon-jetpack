package com.universodoandroid.pokemonjetpack.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universodoandroid.pokemonjetpack.main.domain.entity.Pokemon
import com.universodoandroid.pokemonjetpack.main.domain.usecase.GetPokemonsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

internal class PokemonsViewModel(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    init {
        loadPokemons()
    }

    private val pokemonsMutableState = MutableStateFlow<List<Pokemon>>(listOf())

    fun getPokemonsState(): StateFlow<List<Pokemon>> = pokemonsMutableState

    private fun loadPokemons() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                launch {
                    try {
                        val pokemons = getPokemonsUseCase.invoke()
                        pokemonsMutableState.value = pokemons
                    } catch (e: Exception) {

                    }
                }
            }
        }
    }
}