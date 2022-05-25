package com.miharu.planetphoto.core.di

import com.miharu.planetphoto.data.repository.MainRepositoryImpl
import com.miharu.planetphoto.domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class MainDataModule {

    @Binds
    abstract fun provideMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository
}