package com.miharu.planetphoto.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miharu.planetphoto.domain.model.ApodResponse

@Database(entities = [ApodResponse::class], version = 2, exportSchema = false)
abstract class MainAppDatabase : RoomDatabase() {

    abstract fun getAppDao(): MainAppDao
}