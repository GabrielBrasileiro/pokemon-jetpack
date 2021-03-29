package com.universodoandroid.pokemonjetpack.details.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.universodoandroid.pokemonjetpack.details.presentation.viewmodel.PokemonDetailsViewModel
import com.universodoandroid.pokemonjetpack.shared.android.intent.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

const val KEY_NAME_PARAM = "name_key"

internal class PokemonDetailsActivity : AppCompatActivity() {

    private val name by lazy { intent.getStringExtra(KEY_NAME_PARAM).orEmpty() }
    private val viewModel by viewModel<PokemonDetailsViewModel> { parametersOf(name) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        viewModel.getState().observe(this) {
            showToast(it.sprites.frontDefault)
        }
    }
}