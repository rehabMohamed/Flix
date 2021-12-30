package com.flixmobility.challenge.di

import com.flixmobility.challenge.utils.Dispatcher
import com.flixmobility.challenge.utils.DispatcherImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun bindDispatcher(dispatcherImpl: DispatcherImpl): Dispatcher {
        return dispatcherImpl
    }
}