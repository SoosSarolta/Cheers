package hu.bme.aut.cheers.ui.list

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.cheers.domain.CoctailsInteractor
import javax.inject.Inject

class ListPresenter @Inject constructor(
    private val coctailsInteractor: CoctailsInteractor
) {

    suspend fun loadCoctailsByFirstLetter(firstLetter: String): List<CoctailItem> = withIOContext {
        coctailsInteractor.getCoctailsByFirstLetter(firstLetter).map { coctail ->
            CoctailItem(
                id = coctail.id,
                name = coctail.name,
                type = coctail.type,
                thumbnailUrl = coctail.thumbnailUrl,
                alcoholic = coctail.alcoholic,
                ingredients = coctail.ingredients,
                instructions = coctail.instructions
            )
        }
    }

    suspend fun saveCoctailItem(coctailId: String) = withIOContext {
        coctailsInteractor.saveCoctail(coctailId)
    }

    suspend fun deleteCoctailItem(coctailId: String) = withIOContext {
        coctailsInteractor.removeSavedCoctailById(coctailId)
    }

    data class CoctailItem(
        val id: String,
        val name: String,
        val type: String,
        val thumbnailUrl: String,
        val alcoholic: Boolean,
        val ingredients: List<String>,
        val instructions: String
    )
}