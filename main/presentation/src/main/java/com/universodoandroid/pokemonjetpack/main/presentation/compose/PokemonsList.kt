package com.universodoandroid.pokemonjetpack.main.presentation.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.universodoandroid.pokemonjetpack.main.domain.entity.Pokemon

@Composable
fun PokemonsList(pokemons: List<Pokemon>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(pokemons) { pokemon ->
            PokemonItem(pokemon = pokemon)
        }
    }
}

@Composable
fun PokemonItem(pokemon: Pokemon) {
    Text(text = pokemon.name, modifier = Modifier.fillMaxWidth())
}

@Preview("Pokemons list screen")
@Composable
fun PreviewPokemonsList() {
    PokemonsList(
        listOf(
            Pokemon("0", "Gabriel"),
            Pokemon("1", "Lucas"),
        )
    )
}