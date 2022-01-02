package com.flixmobility.challenge.domain.entity

data class DepartureEntity(
    val dateTimeEntity: DateTimeEntity?,
    val lineCode: String = "",
    val direction: String = ""
)
