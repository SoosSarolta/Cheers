package hu.bme.aut.cheers.ui.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class ListViewModel @Inject constructor(private val listPresenter: ListPresenter) : RainbowCakeViewModel<ListViewState>(Initial) {

    init {
        execute { loadCoctails() }
    }

    fun reload() {
        execute { loadCoctails() }
    }

    private suspend fun loadCoctails() {
        // TODO
    }
}