package hu.bme.aut.cheers.data.network

import hu.bme.aut.cheers.domain.Coctail
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val coctailApi: CoctailApi
){
    suspend fun findCoctailById(id: String): Coctail {
        var alcoholic: Boolean
        val ingredients: MutableList<String> = mutableListOf()

        return coctailApi.findCoctailById(id).drinks.let { drinks ->
            alcoholic = drinks[0].strAlcoholic == "Alcoholic"
            ingredients.add(drinks[0].strIngredient1.toString())
            ingredients.add(drinks[0].strIngredient2.toString())
            ingredients.add(drinks[0].strIngredient3.toString())
            ingredients.add(drinks[0].strIngredient4.toString())
            ingredients.add(drinks[0].strIngredient5.toString())
            ingredients.add(drinks[0].strIngredient6.toString())
            ingredients.add(drinks[0].strIngredient7.toString())
            ingredients.add(drinks[0].strIngredient8.toString())
            ingredients.add(drinks[0].strIngredient9.toString())
            ingredients.add(drinks[0].strIngredient10.toString())
            ingredients.add(drinks[0].strIngredient11.toString())
            ingredients.add(drinks[0].strIngredient12.toString())
            ingredients.add(drinks[0].strIngredient13.toString())
            ingredients.add(drinks[0].strIngredient14.toString())
            ingredients.add(drinks[0].strIngredient15.toString())

            Coctail(
                id = drinks[0].idDrink,
                name = drinks[0].strDrink.toString(),
                type = drinks[0].strCategory.toString(),
                thumbnailUrl = drinks[0].strDrinkThumb.toString(),
                alcoholic = alcoholic,
                ingredients = ingredients,
                instructions = drinks[0].strInstructions.toString()
            )
        }
    }

    suspend fun listCoctailsByFirstLetter(firstLetter: String): List<Coctail> {
        var alcoholic: Boolean
        val ingredients: MutableList<String> = mutableListOf()

        return coctailApi.listCoctailsByFirstLetter(firstLetter).drinks.map { drink ->
            alcoholic = drink.strAlcoholic == "Alcoholic"
            ingredients.add(drink.strIngredient1.toString())
            ingredients.add(drink.strIngredient2.toString())
            ingredients.add(drink.strIngredient3.toString())
            ingredients.add(drink.strIngredient4.toString())
            ingredients.add(drink.strIngredient5.toString())
            ingredients.add(drink.strIngredient6.toString())
            ingredients.add(drink.strIngredient7.toString())
            ingredients.add(drink.strIngredient8.toString())
            ingredients.add(drink.strIngredient9.toString())
            ingredients.add(drink.strIngredient10.toString())
            ingredients.add(drink.strIngredient11.toString())
            ingredients.add(drink.strIngredient12.toString())
            ingredients.add(drink.strIngredient13.toString())
            ingredients.add(drink.strIngredient14.toString())
            ingredients.add(drink.strIngredient15.toString())

            Coctail(
                id = drink.idDrink,
                name = drink.strDrink.toString(),
                type = drink.strCategory.toString(),
                thumbnailUrl = drink.strDrinkThumb.toString(),
                alcoholic = alcoholic,
                ingredients = ingredients,
                instructions = drink.strInstructions.toString()
            )
        }

        /*return listOf(
                Coctail(
                        id = "11",
                        name = "trial",
                        type = "cat",
                        thumbnailUrl = "",
                        alcoholic = true,
                        ingredients = listOf("asd", "das"),
                        instructions = "do it"
                ),
                Coctail(
                        id = "112",
                        name = "trial 2",
                        type = "asd",
                        thumbnailUrl = "",
                        alcoholic = false,
                        ingredients = listOf("aaa", "bb"),
                        instructions = "asdfff"
                )
        )*/
    }
}