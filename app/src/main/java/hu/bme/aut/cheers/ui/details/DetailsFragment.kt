package hu.bme.aut.cheers.ui.details

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import hu.bme.aut.cheers.R

class DetailsFragment : RainbowCakeFragment<DetailsViewState, DetailsViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()

    override fun getViewResource() = R.layout.fragment_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO
    }

    override fun render(viewState: DetailsViewState) {
        when(viewState) {
            Initial -> {
                // TODO
            }
            Loading -> {
                // TODO
            }
            is DetailsReady -> {
                // TODO
            }
            NetworkError -> {
                // TODO
            }
        }
    }
}