package com.universodoandroid.pokemonjetpack.main.presentation.flow

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

internal class FlowObserver<T>(
    lifecycleOwner: LifecycleOwner,
    private val flow: Flow<T>,
    private val collector: suspend (T) -> Unit
) : DefaultLifecycleObserver {

    private var job: Job? = null

    init {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    override fun onStart(owner: LifecycleOwner) {
        job = owner.lifecycleScope.launch { flow.collect(collector) }
    }

    override fun onStop(owner: LifecycleOwner) {
        job?.cancel()
    }
}