package hu.bme.aut.cheers.test

import hu.bme.aut.cheers.mock.MockCoctailApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ListTest {
    private lateinit var mockCoctailApi: MockCoctailApi

    @Before
    fun setUp() {
        mockCoctailApi = MockCoctailApi()
    }

    @Test
    fun checkCoctailsLoadedByFirstLetter() {
        runBlocking {
            val list = mockCoctailApi.listCoctailsByFirstLetter("t")
            Assert.assertTrue(list.drinks.isNotEmpty())
            Assert.assertEquals(2, list.drinks.size)
        }
    }
}