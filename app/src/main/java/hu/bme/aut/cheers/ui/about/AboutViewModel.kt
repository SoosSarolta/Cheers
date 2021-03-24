package hu.bme.aut.cheers.ui.about

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class AboutViewModel @Inject constructor(private val aboutPresenter: AboutPresenter) : RainbowCakeViewModel<AboutViewState>(Initial) {

    fun getInfo() {
        // TODO
    }
}