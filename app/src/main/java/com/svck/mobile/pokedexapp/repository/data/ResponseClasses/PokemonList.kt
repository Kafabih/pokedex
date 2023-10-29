package com.svck.mobile.pokedexapp.repository.data.ResponseClasses

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)