package com.flixmobility.challenge.data.mapper

import com.flixmobility.challenge.data.model.DateTimeModel
import com.flixmobility.challenge.data.model.DepartureModel
import com.flixmobility.challenge.domain.entity.DateTime
import com.flixmobility.challenge.domain.entity.Departure
import javax.inject.Inject

class DepartureMapper @Inject constructor() {

    fun toDeparture(departureModel: DepartureModel): Departure {
        return Departure(
            dateTime = toDateTime(departureModel.dateTime),
            lineCode = departureModel.lineCode ?: "",
            direction = departureModel.direction ?: ""
        )
    }

    private fun toDateTime(dateTimeModel: DateTimeModel?): DateTime? {
        return dateTimeModel?.let {
            DateTime(timestamp = it.timestamp , tz = it.tz)
        }
    }
}