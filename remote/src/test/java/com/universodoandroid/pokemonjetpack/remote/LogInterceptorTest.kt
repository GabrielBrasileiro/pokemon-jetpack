package com.universodoandroid.pokemonjetpack.remote

import com.universodoandroid.pokemonjetpack.remote.interceptor.LogInterceptor
import com.universodoandroid.pokemonjetpack.remote.interceptor.LogInterceptorImpl
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.assertEquals
import org.junit.Test

internal class LogInterceptorTest {

    private val logInterceptor: LogInterceptor = LogInterceptorImpl()

    @Test
    fun `logInterceptor Should return intercept level of body`() {
        // Given
        val expected = HttpLoggingInterceptor.Level.BODY

        // When
        val result = logInterceptor.getInterceptor()

        // Then
        assertEquals(expected, result.level)
    }
}