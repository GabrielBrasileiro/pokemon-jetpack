package com.universodoandroid.pokemonjetpack

import android.app.Application
import com.universodoandroid.pokemonjetpack.main.data.di.MainDataModule
import com.universodoandroid.pokemonjetpack.main.domain.di.MainDomainModule
import com.universodoandroid.pokemonjetpack.main.presentation.di.MainPresentationModule
import com.universodoandroid.pokemonjetpack.shared.koin.KoinModule
import com.universodoandroid.pokemonjetpack.shared.koin.load
import com.universodoandroid.pokemonjetpack.start.StartModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("Unused")
class PokemonJetpackApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PokemonJetpackApplication)
        }

        loadModules(
            StartModule(),
            MainDataModule(),
            MainDomainModule(),
            MainPresentationModule(),
        )
    }

    private fun <T : KoinModule> loadModules(vararg modules: T) {
        modules.forEach { it.load() }
    }
}