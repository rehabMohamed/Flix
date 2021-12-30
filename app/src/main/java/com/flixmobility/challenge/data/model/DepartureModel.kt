package com.flixmobility.challenge.data.model

import com.google.gson.annotations.SerializedName

data class DepartureModel(
    @SerializedName("datetime") val dateTime: DateTimeModel?,
    @SerializedName("line_code") val lineCode: String?,
    @SerializedName("direction") val direction: String?
)
