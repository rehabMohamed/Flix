package com.flixmobility.challenge.data.repoimpl

import com.flixmobility.challenge.data.remote.ApiService
import com.flixmobility.challenge.domain.entity.Departure
import com.flixmobility.challenge.domain.repo.TimetableRepo
import com.flixmobility.challenge.data.mapper.DepartureMapper
import javax.inject.Inject

class TimetableRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val departureMapper: DepartureMapper
) : TimetableRepo {

    override suspend fun getDepartures(): List<Departure> {
        return apiService.getTimeTable().timetable?.departures?.map {
            departureMapper.toDeparture(it)
        } ?: listOf()
    }
}