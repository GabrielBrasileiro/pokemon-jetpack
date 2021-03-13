package com.universodoandroid.pokemonjetpack.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.universodoandroid.pokemonjetpack.R
import org.koin.android.ext.android.inject

internal class StartActivity : AppCompatActivity() {

    private val startRouter by inject<StartRouter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startRouter.startMain(this)
        finish()
    }
}

