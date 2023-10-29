package com.svck.mobile.pokedexapp.hilt

import androidx.paging.Pager
import com.svck.mobile.pokedexapp.network.PokeApi
import com.svck.mobile.pokedexapp.repository.PokeRepository
import com.svck.mobile.pokedexapp.repository.data.PokedexListEntry
import com.svck.mobile.pokedexapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun repositoryObject(pokeApi: PokeApi, pager: Pager<Int, PokedexListEntry>) = PokeRepository(pokeApi,pager)

    // When you call a method on the interface, Retrofit automatically
    // generates the necessary code to make the HTTP request and parse the response into a Java or Kotlin object.
    @Singleton
    @Provides
    fun pokeApiObject(): PokeApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build().create(PokeApi::class.java)
    }
}