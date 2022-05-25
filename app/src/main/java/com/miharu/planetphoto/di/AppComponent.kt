package com.miharu.planetphoto.di

import com.miharu.planetphoto.data.DataModule
import com.miharu.planetphoto.presenter.viewmodel.ViewModelModule
import dagger.Component

@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class
    ]

)
interface AppComponent {
}