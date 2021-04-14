package hu.bme.aut.cheers.data.network

import hu.bme.aut.cheers.data.network.model.DrinkWrapper
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoctailApi {

    /**
     * Find coctail by id
     * Add id as query string to find all informations about the given drink
     * @param i Coctail id
     * @return Call<DrinkWrapper>
     */
    @GET("lookup.php")
    suspend fun findCoctailById(@Query("i") i: String): DrinkWrapper

    /**
     * List coctails by first letter
     * Add first letter as query string to list all coctails that match
     * @param f First letter for filtering
     * @return Call<DrinkWrapper>
     */
    @GET("search.php?f={firstLetter}")
    suspend fun listCoctailsByFirstLetter(@Path("firstLetter") firstLetter: String): DrinkWrapper
}