package com.flixmobility.challenge.domain.repo

import com.flixmobility.challenge.domain.entity.DepartureEntity


interface TimetableRepo {
    suspend fun getDepartures(): List<DepartureEntity>
}