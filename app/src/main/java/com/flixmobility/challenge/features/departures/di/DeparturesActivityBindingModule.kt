package com.flixmobility.challenge.features.departures.di

import com.flixmobility.challenge.features.departures.ui.DeparturesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [DeparturesViewModelModule::class])
abstract class DeparturesActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindDeparturesActivity(): DeparturesActivity
}
