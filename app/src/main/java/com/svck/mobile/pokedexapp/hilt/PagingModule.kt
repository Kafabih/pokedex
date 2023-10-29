package com.svck.mobile.pokedexapp.hilt

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.svck.mobile.pokedexapp.helper.mediatorObject
import com.svck.mobile.pokedexapp.network.PokeApi
import com.svck.mobile.pokedexapp.repository.dao.RoomDB
import com.svck.mobile.pokedexapp.repository.data.PokedexListEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PagingModule {
    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun pagerInstance(
        roomDB: RoomDB,
        pokeApi: PokeApi,
    ): Pager<Int, PokedexListEntry> {
        return Pager(
            config =
            PagingConfig(pageSize = 20),
            remoteMediator = mediatorObject(roomDB, pokeApi),
            pagingSourceFactory = {
                roomDB.pokeListDao().getOfflineData()
            }
        )
    }
}