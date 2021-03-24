package hu.bme.aut.cheers.ui.about

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import hu.bme.aut.cheers.R

class AboutFragment : RainbowCakeFragment<AboutViewState, AboutViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()

    override fun getViewResource() = R.layout.fragment_about

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO
    }

    override fun render(viewState: AboutViewState) {
        when(viewState) {
            Initial -> {
                // TODO
            }
            Loading -> {
                // TODO
            }
            is InfoReady -> {
                // TODO
            }
        }
    }
}