package com.flixmobility.challenge.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher

@ExperimentalCoroutinesApi
class DispatcherImplTest: Dispatcher {
    override fun main(): CoroutineDispatcher = UnconfinedTestDispatcher()
    override fun io(): CoroutineDispatcher = UnconfinedTestDispatcher()
    override fun default(): CoroutineDispatcher = UnconfinedTestDispatcher()
}