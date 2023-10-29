package com.acdev.pokedex.Hilt

import android.content.Context
import androidx.room.Room
import com.svck.mobile.pokedexapp.repository.dao.RoomDB
import com.svck.mobile.pokedexapp.utils.DatabaseName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun roomBuilder(@ApplicationContext context: Context): RoomDB {
        return Room.databaseBuilder(context, RoomDB::class.java, DatabaseName).build()
    }

}