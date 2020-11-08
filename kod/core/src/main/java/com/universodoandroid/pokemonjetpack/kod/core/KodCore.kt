package com.universodoandroid.pokemonjetpack.kod.core

import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass

object KodCore {

    private val definitions: ConcurrentHashMap<KClass<*>, Definition<*>> = ConcurrentHashMap()

    inline fun <reified T> get(): T {
        val definitions = getDefinitions()

        val definition = definitions[T::class]?.invoke()
            ?: throw Throwable("No contains instance: ${T::class.java.name}")

        return definition as? T
            ?: throw Throwable("Not possible cast to instance ${T::class.java.name}")
    }

    fun getDefinitions() = definitions

}
