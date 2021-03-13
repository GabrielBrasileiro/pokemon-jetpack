package com.universodoandroid.pokemonjetpack.main.presentation.flow.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.universodoandroid.pokemonjetpack.main.presentation.flow.FlowObserver
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

typealias Observer<S> = suspend (S) -> Unit

fun <S> LifecycleOwner.onStateChanged(
    viewModel: FlowViewModel<S, *>,
    onStateChanged: Observer<S>
) {
    FlowObserver(this, viewModel.getState(), onStateChanged)
}

inline fun <E> LifecycleOwner.onEvent(
    viewModel: FlowViewModel<*, E>,
    crossinline onAction: Observer<E>
): Job {
    return lifecycleScope.launch {
        viewModel.getEvent().collect(onAction)
    }
}