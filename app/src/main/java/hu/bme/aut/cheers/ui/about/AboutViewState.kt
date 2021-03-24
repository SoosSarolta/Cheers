package hu.bme.aut.cheers.ui.about

sealed class AboutViewState

object Initial : AboutViewState()

object Loading : AboutViewState()

data class InfoReady(val result: String) : AboutViewState()