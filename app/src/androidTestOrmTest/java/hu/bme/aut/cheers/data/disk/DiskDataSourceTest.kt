package hu.bme.aut.cheers.data.disk

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import hu.bme.aut.cheers.domain.Coctail
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DiskDataSourceTest {
    private lateinit var coctailDao: CoctailDao
    private lateinit var db: CoctailDatabase
    private lateinit var diskDataSource: DiskDataSource

    private val coctail = Coctail(
        id = "1",
        name = "Test Coctail",
        type = "Test type",
        thumbnailUrl = "",
        alcoholic = true,
        ingredients = listOf("Test 1, Test 2"),
        instructions = "Testing"
    )

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, CoctailDatabase::class.java).build()
        coctailDao = db.coctailDao()
        diskDataSource = DiskDataSource(coctailDao)
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun getSavedCoctails() {
        val coctail2 = Coctail(
            id = "2",
            name = "Test Coctail 2",
            type = "Test type 2",
            thumbnailUrl = "",
            alcoholic = false,
            ingredients = listOf("Test 2, Test 3"),
            instructions = "Testing 2"
        )

        runBlocking {
            diskDataSource.saveCoctail(coctail)
            diskDataSource.saveCoctail(coctail2)

            val savedCoctails = diskDataSource.getSavedCoctails()
            assertEquals(2, savedCoctails.first().size)
        }
    }

    @Test
    fun getSavedCoctailById() {
        runBlocking {
            diskDataSource.saveCoctail(coctail)
            val coctailTest = diskDataSource.getSavedCoctailById(coctail.id)
            assertEquals(coctail.id, coctailTest!!.id)
        }
    }

    @Test
    fun saveCoctail() {
        runBlocking {
            diskDataSource.saveCoctail(coctail)
            val coctailTest = diskDataSource.getSavedCoctailById(coctail.id)
            assertEquals(coctail.id, coctailTest!!.id)
            assertEquals(coctail.name, coctailTest.name)
            assertEquals(coctail.type, coctailTest.type)
            assertEquals(coctail.thumbnailUrl, coctailTest.thumbnailUrl)
            assertEquals(coctail.alcoholic, coctailTest.alcoholic)
            assertEquals(coctail.instructions, coctailTest.instructions)
        }
    }

    @Test
    fun removeSavedCoctailById() {
        runBlocking {
            diskDataSource.saveCoctail(coctail)
            diskDataSource.removeSavedCoctailById(coctail.id)
            assertEquals(diskDataSource.getSavedCoctailById(coctail.id), null)
        }
    }
}