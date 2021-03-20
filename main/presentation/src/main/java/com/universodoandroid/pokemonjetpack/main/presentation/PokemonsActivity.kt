package com.universodoandroid.pokemonjetpack.main.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import com.mvvmredux.ext.onEvent
import com.universodoandroid.pokemonjetpack.main.presentation.compose.PokemonsList
import com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.PokemonsViewModel
import com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.reducer.PokemonsEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class PokemonsActivity : AppCompatActivity() {

    private val viewModel by viewModel<PokemonsViewModel>()

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
                is PokemonsEvent.OpenDetails -> showToast("Open details with id: ${event.id}")
                is PokemonsEvent.ShowInStart -> showToast("Show in start")
            }
        }
    }

    private fun showToast(str: String) {
        Toast.makeText(this@PokemonsActivity, str, Toast.LENGTH_SHORT).show()
    }
}