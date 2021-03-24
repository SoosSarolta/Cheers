package hu.bme.aut.cheers.ui.list

import hu.bme.aut.cheers.domain.CoctailsInteractor
import javax.inject.Inject

class ListPresenter @Inject constructor(private val coctailsInteractor: CoctailsInteractor) {

    suspend fun loadCoctailItems() {
        // TODO
    }
}