package com.flixmobility.challenge.domain.repo

import com.flixmobility.challenge.domain.entity.Departure


interface TimetableRepo {
    suspend fun getDepartures(): List<Departure>
}