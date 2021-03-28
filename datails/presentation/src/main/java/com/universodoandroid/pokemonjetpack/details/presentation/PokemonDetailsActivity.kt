package com.universodoandroid.pokemonjetpack.details.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.universodoandroid.pokemonjetpack.shared.android.intent.showToast

const val KEY_NAME_PARAM = "name_key"

internal class PokemonDetailsActivity : AppCompatActivity() {

    private val name by lazy { intent.getStringExtra(KEY_NAME_PARAM).orEmpty() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        showToast(name)
    }
}