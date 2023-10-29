package com.svck.mobile.pokedexapp.repository.data.ResponseClasses

import com.google.gson.annotations.SerializedName
import com.svck.mobile.pokedexapp.repository.data.ResponseClasses.XY

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyalphasapphire: OmegarubyAlphasapphire,
    @SerializedName("x-y")
    val xy: XY
)