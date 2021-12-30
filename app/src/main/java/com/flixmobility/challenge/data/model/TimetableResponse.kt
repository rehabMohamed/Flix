package com.flixmobility.challenge.data.model

import com.google.gson.annotations.SerializedName

data class TimetableResponse(
    @SerializedName("timetable") val timetable: Timetable?
)
