package com.universodoandroid.pokemonjetpack.koin

import com.universodoandroid.pokemonjetpack.details.presentation.di.DetailsModule
import com.universodoandroid.pokemonjetpack.main.data.di.MainDataModule
import com.universodoandroid.pokemonjetpack.main.domain.di.MainDomainModule
import com.universodoandroid.pokemonjetpack.main.presentation.di.MainPresentationModule
import com.universodoandroid.pokemonjetpack.remote.di.RemoteModule
import com.universodoandroid.pokemonjetpack.shared.common.koin.KoinModule
import com.universodoandroid.pokemonjetpack.shared.common.koin.load
import com.universodoandroid.pokemonjetpack.start.StartModule

internal class KoinModules {

    fun startKoinModules() {
        loadModules(
            StartModule(),
            MainDataModule(),
            MainDomainModule(),
            MainPresentationModule(),
            DetailsModule(),
            RemoteModule(),
        )
    }

    private fun <T : KoinModule> loadModules(vararg modules: T) {
        modules.forEach { it.load() }
    }
}