package com.svck.mobile.pokedexapp.repository.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.svck.mobile.pokedexapp.utils.tableNameOfSinglePokemon

@Entity(tableName = tableNameOfSinglePokemon)
data class PokedexListEntry(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val name: String,
    val imageUrl: String)