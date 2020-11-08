package com.universodoandroid.pokemonjetpack.main.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.mvvmredux.viewmodel.getViewModel
import com.universodoandroid.pokemonjetpack.kod.core.KodCore
import com.universodoandroid.pokemonjetpack.main.data.di.MainDataKod
import com.universodoandroid.pokemonjetpack.main.domain.di.MainDomainKod
import kotlinx.coroutines.flow.collect

class PokemonsActivity : AppCompatActivity() {

    private val viewModel by getViewModel { PokemonsViewModel(KodCore.get()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainDomainKod.load()
        MainDataKod.load()

        lifecycleScope.launchWhenCreated {
            viewModel.getPokemonsState().collect {
                Toast.makeText(this@PokemonsActivity, it.joinToString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}