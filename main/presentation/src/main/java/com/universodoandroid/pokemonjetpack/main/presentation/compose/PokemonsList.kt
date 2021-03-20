package com.universodoandroid.pokemonjetpack.main.presentation.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.universodoandroid.pokemonjetpack.main.domain.entity.Pokemon
import com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.PokemonsViewModel

@Composable
fun PokemonsList(viewModel: PokemonsViewModel) {
    val state by viewModel.getState().observeAsState()
    PokemonComponent(state?.pokemons ?: listOf()) { viewModel.openDetails(it) }
}

@Composable
fun PokemonComponent(pokemons: List<Pokemon>, onClick: (id: String) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(pokemons) { pokemon ->
            PokemonItem(
                pokemon = pokemon,
                onClick = onClick
            )
        }
    }
}

@Composable
fun PokemonItem(pokemon: Pokemon, onClick: (id: String) -> Unit) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 4.dp,
                vertical = 4.dp
            )
            .clickable(
                onClick = { onClick(pokemon.id) }
            ),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = pokemon.name,
        )
    }
}

@Preview("Pokemons list screen")
@Composable
fun PreviewPokemonsList() {
    PokemonComponent(
        listOf(
            Pokemon("0", "Gabriel"),
            Pokemon("1", "Lucas"),
        )
    ) {}
}