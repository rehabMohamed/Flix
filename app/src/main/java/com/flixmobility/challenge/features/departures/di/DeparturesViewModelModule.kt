package com.flixmobility.challenge.features.departures.di

import androidx.lifecycle.ViewModel
import com.flixmobility.challenge.di.ViewModelKey
import com.flixmobility.challenge.features.departures.ui.DeparturesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DeparturesViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DeparturesViewModel::class)
    abstract fun bindDeparturesViewModel(viewModel: DeparturesViewModel): ViewModel
}