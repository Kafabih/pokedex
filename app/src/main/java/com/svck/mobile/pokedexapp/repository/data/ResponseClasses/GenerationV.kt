package com.svck.mobile.pokedexapp.repository.data.ResponseClasses

import com.google.gson.annotations.SerializedName

data class GenerationV(
    @SerializedName("black-white")
    val blackwhite: BlackWhite
)