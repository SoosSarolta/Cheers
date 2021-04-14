package hu.bme.aut.cheers.data.network

import android.util.Log
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
            ingredients.add(drinks[0].strIngredient1)
            ingredients.add(drinks[0].strIngredient2)
            ingredients.add(drinks[0].strIngredient3)
            ingredients.add(drinks[0].strIngredient4)
            ingredients.add(drinks[0].strIngredient5)
            ingredients.add(drinks[0].strIngredient6)
            ingredients.add(drinks[0].strIngredient7)
            ingredients.add(drinks[0].strIngredient8)
            ingredients.add(drinks[0].strIngredient9)
            ingredients.add(drinks[0].strIngredient10)
            ingredients.add(drinks[0].strIngredient11)
            ingredients.add(drinks[0].strIngredient12)
            ingredients.add(drinks[0].strIngredient13)
            ingredients.add(drinks[0].strIngredient14)
            ingredients.add(drinks[0].strIngredient15)

            Coctail(
                id = drinks[0].idDrink,
                name = drinks[0].strDrink,
                type = drinks[0].strCategory,
                thumbnailUrl = drinks[0].strDrinkThumb,
                alcoholic = alcoholic,
                ingredients = ingredients,
                instructions = drinks[0].strInstructions
            )
        }
    }

    suspend fun listCoctailsByFirstLetter(firstLetter: String): List<Coctail> {
        var alcoholic: Boolean
        val ingredients: MutableList<String> = mutableListOf()

        val a = coctailApi.listCoctailsByFirstLetter(firstLetter)

        return coctailApi.listCoctailsByFirstLetter(firstLetter).drinks.map { drink ->
            alcoholic = drink.strAlcoholic == "Alcoholic"
            ingredients.add(drink.strIngredient1)
            ingredients.add(drink.strIngredient2)
            ingredients.add(drink.strIngredient3)
            ingredients.add(drink.strIngredient4)
            ingredients.add(drink.strIngredient5)
            ingredients.add(drink.strIngredient6)
            ingredients.add(drink.strIngredient7)
            ingredients.add(drink.strIngredient8)
            ingredients.add(drink.strIngredient9)
            ingredients.add(drink.strIngredient10)
            ingredients.add(drink.strIngredient11)
            ingredients.add(drink.strIngredient12)
            ingredients.add(drink.strIngredient13)
            ingredients.add(drink.strIngredient14)
            ingredients.add(drink.strIngredient15)

            Coctail(
                id = drink.idDrink,
                name = drink.strDrink,
                type = drink.strCategory,
                thumbnailUrl = drink.strDrinkThumb,
                alcoholic = alcoholic,
                ingredients = ingredients,
                instructions = drink.strInstructions
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