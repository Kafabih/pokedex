package com.svck.mobile.pokedexapp.repository.data.ResponseClasses

import com.google.gson.annotations.SerializedName

data class Other(
    val dream_world: DreamWorld,
    val home: Home,
    @SerializedName("official-artwork")
    val officialartwork: OfficialArtwork
)