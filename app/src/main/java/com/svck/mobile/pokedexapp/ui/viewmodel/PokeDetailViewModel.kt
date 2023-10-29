package com.svck.mobile.pokedexapp.ui.viewmodel


import androidx.lifecycle.ViewModel
import com.svck.mobile.pokedexapp.repository.PokeRepository
import com.svck.mobile.pokedexapp.repository.data.ResponseClasses.PokemonData
import com.svck.mobile.pokedexapp.utils.ResultProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokeDetailViewModel @Inject constructor(private val repository: PokeRepository) :
    ViewModel() {
    suspend fun getPokemonInfo(name: String): ResultProvider<PokemonData> {
        return repository.getPokemon(name)
    }
}