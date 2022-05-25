package com.miharu.planetphoto.core.di

import com.miharu.planetphoto.data.DataModule
import dagger.Component

@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class
    ]

)
interface AppComponent {
}