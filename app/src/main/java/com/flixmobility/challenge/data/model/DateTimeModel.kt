package com.flixmobility.challenge.data.model

import com.google.gson.annotations.SerializedName

data class DateTimeModel(
    @SerializedName("timestamp") val timestamp: Long?,
    @SerializedName("tz") val tz: String?
)
