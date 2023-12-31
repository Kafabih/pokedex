package com.svck.mobile.pokedexapp.repository.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.svck.mobile.pokedexapp.repository.data.PokedexListEntry
import com.svck.mobile.pokedexapp.repository.data.RemoteKeys

@Database(entities = [PokedexListEntry::class, RemoteKeys::class], version = 1)
abstract class RoomDB : RoomDatabase() {
    abstract fun pokeListDao(): PokeListDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}