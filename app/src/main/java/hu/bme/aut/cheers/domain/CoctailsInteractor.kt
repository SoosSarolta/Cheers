package hu.bme.aut.cheers.domain

import hu.bme.aut.cheers.data.disk.DiskDataSource
import hu.bme.aut.cheers.data.network.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoctailsInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val diskDataSource: DiskDataSource
) {

    suspend fun getCoctailsByFirstLetter(firstLetter: String): List<Coctail> {
        return networkDataSource.listCoctailsByFirstLetter(firstLetter)
    }

    fun getSavedCoctails(): Flow<List<Coctail>> {
        return diskDataSource.getSavedCoctails()
    }

    suspend fun saveCoctail(id: String) {
        val item = requireNotNull(networkDataSource.findCoctailById(id))
        diskDataSource.saveCoctail(item)
    }

    suspend fun removeSavedCoctailById(id: String) {
        diskDataSource.removeSavedCoctailById(id)
    }

    suspend fun getCoctailById(id: String): Coctail {
        return diskDataSource.getSavedCoctailById(id) ?: networkDataSource.findCoctailById(id)
    }
}