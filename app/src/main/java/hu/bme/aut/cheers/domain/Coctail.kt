package hu.bme.aut.cheers.domain

data class Coctail(
    val id: String,
    val name: String,
    val type: String,
    val thumbnailUrl: String,
    val alcoholic: Boolean,
    val ingredients: List<String>,
    val instructions: String
)