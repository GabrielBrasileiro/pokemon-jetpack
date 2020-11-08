package com.universodoandroid.pokemonjetpack.kod.core

import com.universodoandroid.pokemonjetpack.kod.core.definition.KodDefinition

fun loadKods(definitions: List<KodDef>) {
    val kodDef = KodDefinition()
    definitions.forEach { it.invoke(kodDef) }
}

fun loadKod(definition: KodDef) {
    val kodDef = KodDefinition()
    definition.invoke(kodDef)
}

fun kod(definition: KodDef): KodDef {
    return definition
}