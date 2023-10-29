package com.svck.mobile.pokedexapp.network

import com.svck.mobile.pokedexapp.repository.data.ResponseClasses.PokemonData
import com.svck.mobile.pokedexapp.repository.data.ResponseClasses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonData(
        @Path("name") name: String,
    ): PokemonData

}