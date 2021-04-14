package hu.bme.aut.cheers.data.disk

import hu.bme.aut.cheers.data.disk.entities.RoomCoctail
import hu.bme.aut.cheers.domain.Coctail

fun Coctail.toRoomCoctailItem(): RoomCoctail {
    var stringIngredients = ""
    for (i in ingredients)
        stringIngredients += "$i, "

    return RoomCoctail(
        id = id,
        name = name,
        type = type,
        thumbnailUrl = thumbnailUrl,
        alcoholic = alcoholic,
        ingredients = stringIngredients,
        instructions = instructions
    )
}

fun RoomCoctail.toCoctail(): Coctail {
    val listIngredients: List<String> = ingredients.split(",")

    return Coctail(
        id = id,
        name = name,
        type = type,
        thumbnailUrl = thumbnailUrl,
        alcoholic = alcoholic,
        ingredients = listIngredients,
        instructions = instructions
    )
}