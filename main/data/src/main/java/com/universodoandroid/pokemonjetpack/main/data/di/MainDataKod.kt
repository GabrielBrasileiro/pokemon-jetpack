package com.universodoandroid.pokemonjetpack.main.data.di

import com.universodoandroid.pokemonjetpack.kod.core.loadKod
import com.universodoandroid.pokemonjetpack.main.data.repository.PokemonsRepositoryImpl
import com.universodoandroid.pokemonjetpack.main.domain.repository.PokemonsRepository

object MainDataKod {

    fun load() {
        loadKod {
            factory<PokemonsRepository> { PokemonsRepositoryImpl() }
        }
    }
}