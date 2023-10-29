package com.svck.mobile.pokedexapp.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.svck.mobile.pokedexapp.repository.data.RemoteKeys

@Dao
interface RemoteKeysDao {
    @Query("SELECT * FROM KEYS_TABLE WHERE id=:id")
    suspend fun getRemoteKey(id:String): RemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKeysIntoDB(remoteKey: RemoteKeys)

    @Query("DELETE FROM KEYS_TABLE WHERE id = :id")
    suspend fun deleteById(id: String)
}