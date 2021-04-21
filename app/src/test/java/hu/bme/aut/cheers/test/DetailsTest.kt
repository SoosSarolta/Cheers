package hu.bme.aut.cheers.test

import hu.bme.aut.cheers.mock.MockCoctailApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class DetailsTest {
    private lateinit var mockCoctailApi: MockCoctailApi

    @Before
    fun setUp() {
        mockCoctailApi = MockCoctailApi()
    }

    @Test
    fun checkCoctailDetailsLoadedById() {
        runBlocking {
            val coctail = mockCoctailApi.findCoctailById("1")
            Assert.assertTrue(coctail.drinks.isNotEmpty())
            Assert.assertEquals(1, coctail.drinks.size)
            Assert.assertEquals("1", coctail.drinks[0].idDrink)
        }
    }
}