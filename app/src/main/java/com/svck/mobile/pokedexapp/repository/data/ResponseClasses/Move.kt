package com.svck.mobile.pokedexapp.repository.data.ResponseClasses

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)