package hu.bme.aut.cheers.ui.list

sealed class ListViewState

object Initial : ListViewState()

object Loading : ListViewState()

data class ListReady(val result: String) : ListViewState()

object NetworkError : ListViewState()
