package com.flixmobility.challenge.utils

import kotlinx.coroutines.CoroutineDispatcher

interface Dispatcher {
    fun main(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
    fun default(): CoroutineDispatcher
}