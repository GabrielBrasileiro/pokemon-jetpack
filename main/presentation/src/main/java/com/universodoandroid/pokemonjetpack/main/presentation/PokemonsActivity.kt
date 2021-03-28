package com.universodoandroid.pokemonjetpack.main.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import com.mvvmredux.ext.onEvent
import com.universodoandroid.pokemonjetpack.main.presentation.compose.PokemonsList
import com.universodoandroid.pokemonjetpack.main.presentation.router.PokemonsRouter
import com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.PokemonsViewModel
import com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.reducer.PokemonsEvent
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

internal class PokemonsActivity : AppCompatActivity() {

    private val viewModel by viewModel<PokemonsViewModel>()
    private val router by inject<PokemonsRouter> { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PokemonsList(viewModel)
            }
        }
        setupEventListener()
    }

    private fun setupEventListener() {
        onEvent(viewModel) { event ->
            when (event) {
                is PokemonsEvent.OpenDetails -> router.startDetails(event.name)
                is PokemonsEvent.ShowInStart -> showToast("Show in start")
            }
        }
    }

    private fun showToast(str: String) {
        Toast.makeText(this@PokemonsActivity, str, Toast.LENGTH_SHORT).show()
    }
}