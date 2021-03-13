package com.universodoandroid.pokemonjetpack.main.presentation.navigation

import android.content.Context
import android.content.Intent
import com.universodoandroid.pokemonjetpack.main.presentation.PokemonsActivity
import com.universodoandroid.pokemonsjetpack.navigation.main.MainNavigation

internal class MainNavigationImpl : MainNavigation {

    override fun getIntent(context: Context): Intent {
        return Intent(context, PokemonsActivity::class.java)
    }
}