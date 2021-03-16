package com.example.ntestcase.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ntestcase.data.dao.MainCardDao
import com.example.ntestcase.viewholder.MainCardDTO

@Database(entities = [MainCardDTO::class], version = 1, exportSchema = false)
abstract class NesineDB : RoomDatabase() {
    abstract fun mainCardDao(): MainCardDao
}