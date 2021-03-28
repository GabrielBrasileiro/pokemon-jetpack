package com.universodoandroid.pokemonjetpack.shared.android.intent

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

typealias IntentDef = Intent.() -> Unit

inline fun <reified A : Activity> Context.startActivity(args: IntentDef = {}) {
    startActivity(createIntent<A>(args))
}

inline fun <reified A : Activity> Context.createIntent(args: IntentDef = {}): Intent {
    return Intent(this, A::class.java).apply(args)
}

fun Context.showToast(text: String, time: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, time).show()
}