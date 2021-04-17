package hu.bme.aut.cheers.ormTest

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import hu.bme.aut.cheers.data.disk.CoctailDao
import hu.bme.aut.cheers.data.disk.CoctailDatabase
import hu.bme.aut.cheers.domain.Coctail
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DiskDataSourceTest {
    private lateinit var coctailDao: CoctailDao
    private lateinit var db: CoctailDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, CoctailDatabase::class.java).build()
        coctailDao = db.coctailDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun getSavedCoctailsTest() {
        // TODO
    }

    @Test
    @Throws(Exception::class)
    fun getSavedCoctailByIdTest(id: String) {
        // TODO
    }

    @Test
    @Throws(Exception::class)
    fun saveCoctailTest(coctail: Coctail) {
        // TODO
    }

    @Test
    @Throws(Exception::class)
    fun removeSavedCoctailById(id: String) {
        // TODO
    }
}