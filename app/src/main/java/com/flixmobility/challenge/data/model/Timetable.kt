package com.flixmobility.challenge.data.model

import com.google.gson.annotations.SerializedName

data class Timetable(
    @SerializedName("departures") val departures: List<DepartureModel>?
)
