package com.svck.mobile.pokedexapp.repository.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.svck.mobile.pokedexapp.repository.data.PokedexListEntry

@Dao
interface PokeListDao {
    @Query("SELECT * FROM POKEMON_TABLE")
    fun getOfflineData(): PagingSource<Int, PokedexListEntry>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataIntoDB(pokeList: List<PokedexListEntry>)

    @Query("DELETE FROM POKEMON_TABLE")
    suspend fun clearAll()
}