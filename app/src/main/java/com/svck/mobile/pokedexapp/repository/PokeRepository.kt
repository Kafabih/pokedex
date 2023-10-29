package com.svck.mobile.pokedexapp.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import com.svck.mobile.pokedexapp.network.PokeApi
import com.svck.mobile.pokedexapp.repository.data.PokedexListEntry
import com.svck.mobile.pokedexapp.repository.data.ResponseClasses.PokemonData
import com.svck.mobile.pokedexapp.utils.ResultProvider
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokeRepository @Inject constructor(
    private val pokeApi: PokeApi,
    private val pager: Pager<Int, PokedexListEntry>,
) {
    fun getPokemonList(): Flow<PagingData<PokedexListEntry>> {
        return pager.flow
    }

    suspend fun getPokemon(name: String): ResultProvider<PokemonData> {

        val response = try {
            pokeApi.getPokemonData(name.lowercase())
        } catch (e: Exception) {
            return ResultProvider.Error(msg = "Internet Connection Lost !")
        }
        return ResultProvider.Success(response)
    }
}