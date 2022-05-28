package com.miharu.planetphoto.core.di

import com.miharu.planetphoto.data.repository.MainRepositoryImpl
import com.miharu.planetphoto.data.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [RemoteModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class MainDataModule {

    @Binds
    @Singleton
    abstract fun provideMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository
}