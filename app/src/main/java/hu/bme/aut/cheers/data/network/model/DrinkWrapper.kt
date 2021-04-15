package hu.bme.aut.cheers.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class DrinkWrapper(
    val drinks: List<Drink>
)
