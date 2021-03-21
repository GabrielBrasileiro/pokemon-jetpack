package com.universodoandroid.pokemonjetpack.remote

import com.universodoandroid.pokemonjetpack.remote.setup.DefaultRequest
import com.universodoandroid.pokemonjetpack.remote.setup.DefaultRequestImpl
import io.ktor.http.*
import org.junit.Assert.assertEquals
import org.junit.Test

internal class DefaultRequestTest {

    private val defaultRequest: DefaultRequest = DefaultRequestImpl()

    @Test
    fun `url Should return default api`() {
        // Given
        val expected = "pokeapi.co/api/v2"

        // When
        val result = defaultRequest.getUrl()

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `url Should return default protocol`() {
        // Given
        val expected = URLProtocol.HTTPS

        // When
        val result = defaultRequest.getProtocol()

        // Then
        assertEquals(expected, result)
    }
}