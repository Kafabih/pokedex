package com.svck.mobile.pokedexapp.repository.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.svck.mobile.pokedexapp.utils.tableNameOfRemoteKeys

@Entity(tableName = tableNameOfRemoteKeys)
data class RemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    val nextOffset: Int,
)
