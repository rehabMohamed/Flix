package com.flixmobility.challenge.domain.usecase

import com.flixmobility.challenge.domain.entity.Departure
import com.flixmobility.challenge.domain.repo.TimetableRepo
import javax.inject.Inject

class DeparturesUseCase @Inject constructor(private val timetableRepo: TimetableRepo) {

    suspend fun getDepartures(): List<Departure> {
        return timetableRepo.getDepartures()
    }
}