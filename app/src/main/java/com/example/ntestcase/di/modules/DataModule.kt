package com.example.ntestcase.di.modules

import android.content.Context
import androidx.room.Room
import com.example.core.common.constants.AppConstants
import com.example.core.di.qualifiers.ApplicationContext
import com.example.ntestcase.data.NesineDB
import com.example.ntestcase.data.dao.RoomCallbackSetup
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    private lateinit var db1: NesineDB

    @Singleton
    @Provides
    fun provideNesineDB(@ApplicationContext app: Context): NesineDB {
        db1 = Room.databaseBuilder(
            app,
            NesineDB::class.java,
            AppConstants.DB_NAME
        ).addCallback(RoomCallbackSetup()).build()
        return db1
    }

    @Singleton
    @Provides
    fun provideMatchDao(db: NesineDB) = db.mainCardDao()
}