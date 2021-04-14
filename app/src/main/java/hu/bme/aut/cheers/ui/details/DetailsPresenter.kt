package hu.bme.aut.cheers.ui.details

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.cheers.domain.CoctailsInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val coctailsInteractor: CoctailsInteractor
) {

    suspend fun getCoctailItemById(id: String): DetailedCoctail = withIOContext {
        coctailsInteractor.getCoctailById(id).let { coctail ->
            DetailedCoctail(
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

    data class DetailedCoctail(
        val id: String,
        val name: String,
        val type: String,
        val thumbnailUrl: String,
        val alcoholic: Boolean,
        val ingredients: List<String>,
        val instructions: String
    )
}