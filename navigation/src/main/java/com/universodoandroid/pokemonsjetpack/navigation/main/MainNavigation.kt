package com.universodoandroid.pokemonsjetpack.navigation.main

import android.content.Context
import android.content.Intent

interface MainNavigation {
    fun getIntent(context: Context): Intent
}