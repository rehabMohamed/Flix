package com.flixmobility.challenge.domain.usecase

import com.flixmobility.challenge.domain.entity.DateTime
import com.flixmobility.challenge.domain.entity.Departure
import com.flixmobility.challenge.domain.repo.TimetableRepo
import kotlinx.coroutines.runBlocking
import org.junit.Assert

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class DeparturesUseCaseTest {

    lateinit var departuresUseCase: DeparturesUseCase

    @Mock
    lateinit var timetableRepo: TimetableRepo

    @Before
    fun setUp() {
        departuresUseCase = DeparturesUseCase(timetableRepo)
    }

    @Test
    fun `getDepartures() calls getDepartures() in timetableRepo`() {
        runBlocking {
            departuresUseCase.getDepartures()
            verify(timetableRepo).getDepartures()
        }
    }

    @Test
    fun `getDepartures() returns the correct data`() {
        runBlocking {
            val expected = listOf(Departure(DateTime(1461056400L, "GMT+02:00"), "L007", "Berlin"))
            `when`(timetableRepo.getDepartures()).thenReturn(expected)
            val result = departuresUseCase.getDepartures()
            Assert.assertEquals(expected, result)
        }
    }
}