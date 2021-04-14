package hu.bme.aut.cheers.data.disk

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.bme.aut.cheers.data.disk.entities.RoomCoctail

@Database(
    entities = [RoomCoctail::class],
    version = 1,
    exportSchema = false
)
abstract class CoctailDatabase : RoomDatabase() {
    abstract fun coctailDao(): CoctailDao
}