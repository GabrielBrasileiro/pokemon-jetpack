package com.universodoandroid.pokemonjetpack.main.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mvvmredux.ext.onEvent
import com.mvvmredux.ext.onStateChanged
import com.universodoandroid.pokemonjetpack.main.presentation.reducer.PokemonsEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonsActivity : AppCompatActivity(R.layout.pokemons_activity) {

    private val viewModel by viewModel<PokemonsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupStateListener()
        setupEventListener()

        findViewById<Button>(R.id.button).setOnClickListener { viewModel.showInStart() }
    }

    private fun setupStateListener() {
        onStateChanged(viewModel) {
            showToast(it.toString())
        }
    }

    private fun setupEventListener() {
        onEvent(viewModel) {
            when (it) {
                is PokemonsEvent.ShowInStart -> showToast("Rotate")
            }
        }
    }

    private fun showToast(str: String) {
        Toast.makeText(this@PokemonsActivity, str, Toast.LENGTH_SHORT).show()
    }
}