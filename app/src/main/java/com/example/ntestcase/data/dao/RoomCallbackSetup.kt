package com.example.ntestcase.data.dao

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

class RoomCallbackSetup : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        db.execSQL("INSERT INTO table_card (mainCardType,mainCardNumberOfViews) VALUES ('Type 1',0)")
        db.execSQL("INSERT INTO table_card (mainCardType,mainCardNumberOfViews) VALUES ('Type 2',0)")
        db.execSQL("INSERT INTO table_card (mainCardType,mainCardNumberOfViews) VALUES ('Type 3',0)")
    }
}