package com.universodoandroid.pokemonjetpack

import android.app.Application
import com.universodoandroid.pokemonjetpack.koin.KoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("Unused")
class PokemonJetpackApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PokemonJetpackApplication)
        }
        KoinModules().startKoinModules()
    }
}