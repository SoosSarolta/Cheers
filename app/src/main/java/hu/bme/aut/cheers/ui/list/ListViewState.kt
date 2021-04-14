package hu.bme.aut.cheers.ui.list

sealed class ListViewState

object Loading : ListViewState()

data class ListReady(val result: List<ListPresenter.CoctailItem>) : ListViewState()

object NetworkError : ListViewState()
