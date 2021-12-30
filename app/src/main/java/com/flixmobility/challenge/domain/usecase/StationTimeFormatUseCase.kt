package com.flixmobility.challenge.domain.usecase

import com.flixmobility.challenge.domain.entity.DateTime
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject

const val STATION_TIME_PATTERN = "HH:mm"

class StationTimeFormatUseCase @Inject constructor() {

    fun getStationTime(dateTime: DateTime?) : String {
        return dateTime?.let {
            val tz = it.tz?.let { timezoneId ->
                TimeZone.getTimeZone(timezoneId)
            } ?: TimeZone.getDefault()
            val formatter = SimpleDateFormat(STATION_TIME_PATTERN, Locale.getDefault())
                .apply {
                    timeZone = tz
            }
            it.timestamp?.let { timestamp ->
                formatter.format(Date(timestamp))
            } ?: ""
        } ?: ""
    }
}