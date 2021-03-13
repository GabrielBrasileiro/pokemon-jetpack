package com.universodoandroid.pokemonjetpack.main.presentation.reducer

import com.mvvmredux.core.event.Event

sealed class PokemonsEvent : Event {

    object ShowInStart : PokemonsEvent()
}