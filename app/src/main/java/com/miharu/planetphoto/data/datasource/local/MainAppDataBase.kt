package com.miharu.planetphoto.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [], version = 1, exportSchema = false)
abstract class MainAppDatabase : RoomDatabase() {

    abstract fun getAppDao(): MainAppDao
}