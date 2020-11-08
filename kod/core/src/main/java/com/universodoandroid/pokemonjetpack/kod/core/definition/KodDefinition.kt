package com.universodoandroid.pokemonjetpack.kod.core.definition

import com.universodoandroid.pokemonjetpack.kod.core.Definition
import com.universodoandroid.pokemonjetpack.kod.core.KodCore

class KodDefinition {

    @PublishedApi
    internal val locator = KodCore.getDefinitions()

    inline fun <reified T> factory(noinline definition: Definition<out T>) {
        locator[T::class] = definition
    }

    inline fun <reified T> get(): T {
        return KodCore.get()
    }
}
