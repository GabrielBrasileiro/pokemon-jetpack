package com.universodoandroid.pokemonjetpack.details.presentation.navigation

import android.content.Context
import android.content.Intent
import com.universodoandroid.pokemonjetpack.details.presentation.KEY_NAME_PARAM
import com.universodoandroid.pokemonjetpack.details.presentation.PokemonDetailsActivity
import com.universodoandroid.pokemonjetpack.shared.android.intent.createIntent
import com.universodoandroid.pokemonsjetpack.navigation.main.DetailsNavigation

internal class DetailsNavigationImpl : DetailsNavigation {

    override fun getIntent(context: Context, name: String): Intent {
        return context.createIntent<PokemonDetailsActivity> {
            putExtra(KEY_NAME_PARAM, name)
        }
    }
}