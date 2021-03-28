package com.universodoandroid.pokemonjetpack.start

import android.content.Context
import com.universodoandroid.pokemonsjetpack.navigation.main.MainNavigation

internal class StartRouter(private val mainNavigation: MainNavigation) {

    fun startMain(context: Context) {
        context.startActivity(mainNavigation.getIntent(context))
    }
}