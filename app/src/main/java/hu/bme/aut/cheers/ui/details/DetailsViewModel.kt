package hu.bme.aut.cheers.ui.details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
        private val detailsPresenter: DetailsPresenter
) : RainbowCakeViewModel<DetailsViewState>(Loading) {

        fun loadCoctailById(id: String) = execute {
            val coctail = try {
                 detailsPresenter.getCoctailItemById(id)
            } catch (e: IOException) {
                 Timber.e(e)
                 return@execute
            }
                viewState = DetailsReady(coctail)
        }
}