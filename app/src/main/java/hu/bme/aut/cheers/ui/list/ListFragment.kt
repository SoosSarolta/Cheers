package hu.bme.aut.cheers.ui.list

import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import hu.bme.aut.cheers.R
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : RainbowCakeFragment<ListViewState, ListViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()

    override fun getViewResource() = R.layout.fragment_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO
    }

    override fun render(viewState: ListViewState) {
        TransitionManager.beginDelayedTransition(listFragmentRoot)
        when (viewState) {
            Initial -> {
                // TODO
            }
            Loading -> {
                // TODO
            }
            is ListReady -> {
                // TODO
            }
            NetworkError -> {
                // TODO
            }
        }.exhaustive
    }
}