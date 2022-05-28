package com.miharu.planetphoto.core.di

import android.app.Application
import androidx.room.Room
import com.miharu.planetphoto.data.datasource.local.MainAppDao
import com.miharu.planetphoto.data.datasource.local.MainAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideMainDatabase(application: Application): MainAppDatabase {
        return Room.databaseBuilder(application, MainAppDatabase::class.java, "app_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMainAppDao(db: MainAppDatabase): MainAppDao {
        return db.getAppDao()
    }
}