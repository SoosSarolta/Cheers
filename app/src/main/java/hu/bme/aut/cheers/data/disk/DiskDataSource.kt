package hu.bme.aut.cheers.data.disk

import hu.bme.aut.cheers.data.disk.entities.RoomCoctail
import hu.bme.aut.cheers.domain.Coctail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiskDataSource @Inject constructor(
    private val coctailDao: CoctailDao
) {

    fun getSavedCoctails(): Flow<List<Coctail>> {
        return coctailDao.getAllCoctails().map { coctails -> coctails.map(RoomCoctail::toCoctail) }
    }

    suspend fun getSavedCoctailById(id: String): Coctail? {
        return coctailDao.getCoctailById(id)?.let(RoomCoctail::toCoctail)
    }

    suspend fun saveCoctail(coctail: Coctail) {
        return coctailDao.addCoctail(coctail.toRoomCoctailItem())
    }

    suspend fun removeSavedCoctailById(id: String) {
        coctailDao.removeCoctailById(id)
    }
}