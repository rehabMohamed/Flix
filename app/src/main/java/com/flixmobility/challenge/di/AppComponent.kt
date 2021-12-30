package com.flixmobility.challenge.di

import android.app.Application
import com.flixmobility.challenge.ChallengeApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        ApiModule::class,
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<ChallengeApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}