package com.flixmobility.challenge.data.mapper

import com.flixmobility.challenge.data.model.DateTimeModel
import com.flixmobility.challenge.data.model.DepartureModel
import com.flixmobility.challenge.domain.entity.DateTimeEntity
import com.flixmobility.challenge.domain.entity.DepartureEntity
import javax.inject.Inject

class DepartureMapper @Inject constructor() {

    fun toDeparture(departureModel: DepartureModel): DepartureEntity {
        return DepartureEntity(
            dateTimeEntity = toDateTime(departureModel.dateTime),
            lineCode = departureModel.lineCode ?: "",
            direction = departureModel.direction ?: ""
        )
    }

    private fun toDateTime(dateTimeModel: DateTimeModel?): DateTimeEntity? {
        return dateTimeModel?.let {
            DateTimeEntity(timestamp = it.timestamp , tz = it.tz)
        }
    }
}