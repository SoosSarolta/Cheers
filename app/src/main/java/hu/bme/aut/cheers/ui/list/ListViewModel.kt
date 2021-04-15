package hu.bme.aut.cheers.ui.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.io.IOException
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val listPresenter: ListPresenter
) : RainbowCakeViewModel<ListViewState>(Loading) {

   fun loadCoctailsByFirstLetter(firstLetter: String) = execute {
       viewState = Loading
       viewState = try {
           val items = listPresenter.loadCoctailsByFirstLetter(firstLetter)

           for (coctail in items) {
               listPresenter.saveCoctailItem(coctail.id)
           }

           ListReady(items)
       } catch (e: IOException) {
           NetworkError
       }
   }

    fun deleteCoctailFromLocalDatabase(coctailId: String) = execute {
        listPresenter.deleteCoctailItem(coctailId)
    }
}