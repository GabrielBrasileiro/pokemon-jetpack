package com.universodoandroid.pokemonsjetpack.navigation.main

import android.content.Context
import android.content.Intent

interface DetailsNavigation {
    fun getIntent(context: Context, name: String): Intent
}