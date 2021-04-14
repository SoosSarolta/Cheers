package hu.bme.aut.cheers.data.disk

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hu.bme.aut.cheers.data.disk.entities.RoomCoctail
import kotlinx.coroutines.flow.Flow

@Dao
interface CoctailDao {

    @Query("SELECT * FROM coctails")
    fun getAllCoctails(): Flow<List<RoomCoctail>>

    @Query("SELECT * FROM coctails WHERE id = :id")
    suspend fun getCoctailById(id: String): RoomCoctail?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCoctail(toRoomCoctail: RoomCoctail)

    @Query("DELETE FROM coctails WHERE id = :id")
    suspend fun removeCoctailById(id: String)
}