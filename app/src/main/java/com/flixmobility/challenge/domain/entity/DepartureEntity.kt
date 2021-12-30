package com.flixmobility.challenge.domain.entity

data class DepartureEntity(
    var dateTimeEntity: DateTimeEntity?,
    var lineCode: String = "",
    var direction: String = ""
)
