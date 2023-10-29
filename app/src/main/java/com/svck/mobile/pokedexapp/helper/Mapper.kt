package com.svck.mobile.pokedexapp.helper

import com.svck.mobile.pokedexapp.repository.data.PokedexListEntry
import com.svck.mobile.pokedexapp.repository.data.ResponseClasses.PokemonData
import com.svck.mobile.pokedexapp.repository.data.ResponseClasses.Result


fun List<Result>.toPokeList(): List<PokedexListEntry> {
    return map { pokemon ->
        val idOfPokemon = if (pokemon.url.endsWith("/")) {
            pokemon.url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            pokemon.url.dropLast(1).takeLastWhile { it.isDigit() }
        }
        val imgUrl =
            "https://unpkg.com/pokeapi-sprites@2.0.2/sprites/pokemon/other/dream-world/${idOfPokemon}.svg"
        PokedexListEntry(id = idOfPokemon.toInt(), pokemon.name.uppercase(), imgUrl)
    }
}

fun PokemonData.toPokeDexListEntry(): PokedexListEntry {
    return PokedexListEntry(
        id = this.id,
        name = this.name,
        imageUrl = "https://unpkg.com/pokeapi-sprites@2.0.2/sprites/pokemon/other/dream-world/${this.id}.svg"
    )
}