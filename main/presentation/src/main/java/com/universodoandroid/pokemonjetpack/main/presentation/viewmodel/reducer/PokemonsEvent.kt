package com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.reducer

import com.mvvmredux.core.event.Event

sealed class PokemonsEvent : Event {

    object ShowInStart : PokemonsEvent()
    data class OpenDetails(val id: String) : PokemonsEvent()
}