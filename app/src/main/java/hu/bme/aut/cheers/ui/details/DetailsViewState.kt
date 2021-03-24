package hu.bme.aut.cheers.ui.details

sealed class DetailsViewState

object Initial : DetailsViewState()

object Loading : DetailsViewState()

data class DetailsReady(val result: String) : DetailsViewState()

object NetworkError : DetailsViewState()