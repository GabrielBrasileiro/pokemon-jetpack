package com.universodoandroid.pokemonjetpack.main.domain.di

import com.universodoandroid.pokemonjetpack.kod.core.loadKod
import com.universodoandroid.pokemonjetpack.main.domain.usecase.GetPokemonsUseCase
import com.universodoandroid.pokemonjetpack.main.domain.usecase.GetPokemonsUseCaseImpl

object MainDomainKod {

    fun load() {
        loadKod {
            factory<GetPokemonsUseCase> { GetPokemonsUseCaseImpl(get()) }
        }
    }
}