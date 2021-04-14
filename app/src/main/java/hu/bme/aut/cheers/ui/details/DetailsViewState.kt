package hu.bme.aut.cheers.ui.details

sealed class DetailsViewState

object Loading : DetailsViewState()

data class DetailsReady(val result: DetailsPresenter.DetailedCoctail) : DetailsViewState()

object NetworkError : DetailsViewState()