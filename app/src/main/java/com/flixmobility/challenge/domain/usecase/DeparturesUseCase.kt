package com.flixmobility.challenge.domain.usecase

import com.flixmobility.challenge.domain.entity.DepartureEntity
import com.flixmobility.challenge.domain.entity.Results
import com.flixmobility.challenge.domain.repo.TimetableRepo
import javax.inject.Inject

class DeparturesUseCase @Inject constructor(private val timetableRepo: TimetableRepo) {

    suspend fun getDepartures(): Results<List<DepartureEntity>> {
        return try {
            val response = timetableRepo.getDepartures()
            Results.Success(response)
        } catch (e: Throwable) {
            Results.Error(e)
        }
    }
}