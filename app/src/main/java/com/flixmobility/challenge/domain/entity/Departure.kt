package com.flixmobility.challenge.domain.entity

data class Departure(
    var dateTime: DateTime?,
    var lineCode: String = "",
    var direction: String = ""
)
