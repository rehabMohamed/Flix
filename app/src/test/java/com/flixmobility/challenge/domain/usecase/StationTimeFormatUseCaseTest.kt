package com.flixmobility.challenge.domain.usecase

import com.flixmobility.challenge.domain.entity.DateTimeEntity
import org.junit.Assert.*

import org.junit.Test

class StationTimeFormatUseCaseTest {

    private val timeFormatUseCase = StationTimeFormatUseCase()

    @Test
    fun `getStationTime() with valid timestamp and timezone returns correct time format`() {
        val dateTime = DateTimeEntity(1461056400L, "GMT+02:00")
        val result = timeFormatUseCase.getStationTime(dateTime)
        val expected = "11:00"
        assertEquals(expected, result)
    }

    @Test
    fun `getStationTime() with null timestamp returns empty string`() {
        val dateTime = DateTimeEntity(null, "GMT+02:00")
        val result = timeFormatUseCase.getStationTime(dateTime)
        val expected = ""
        assertEquals(expected, result)
    }

    @Test
    fun `getStationTime() with null timezone returns time with the default timezone`() {
        val dateTime = DateTimeEntity(1461056400L, null)
        val result = timeFormatUseCase.getStationTime(dateTime)
        // should be updated to the machine default timezone
        val expected = "11:00"
        assertEquals(expected, result)
    }

    @Test
    fun `getStationTime() with null dateTime returns empty string`() {
        val dateTime = null
        val result = timeFormatUseCase.getStationTime(dateTime)
        val expected = ""
        assertEquals(expected, result)
    }
}