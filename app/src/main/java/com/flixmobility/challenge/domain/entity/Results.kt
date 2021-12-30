package com.flixmobility.challenge.domain.entity

sealed class Results<out T : Any> {

    class Success<out T : Any>(val data: T) : Results<T>()

    class Error(val throwable: Throwable) : Results<Nothing>()
}