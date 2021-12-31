package com.flixmobility.challenge.features.departures.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.flixmobility.challenge.domain.entity.DateTimeEntity
import com.flixmobility.challenge.domain.entity.DepartureEntity
import com.flixmobility.challenge.domain.entity.Results
import com.flixmobility.challenge.domain.usecase.DeparturesUseCase
import com.flixmobility.challenge.domain.usecase.StationTimeFormatUseCase
import com.flixmobility.challenge.features.departures.models.Departure
import com.flixmobility.challenge.utils.DispatcherImplTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class DeparturesViewModelTest{

    lateinit var departuresViewModel: DeparturesViewModel
    @Mock
    lateinit var departuresUseCase: DeparturesUseCase
    @Mock
    lateinit var stationTimeFormatUseCase: StationTimeFormatUseCase
    @Mock
    lateinit var departuresObserver: Observer<List<Departure>>
    @Mock
    lateinit var errorObserver: Observer<String>
    @ExperimentalCoroutinesApi
    private val dispatcher =  DispatcherImplTest()
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        departuresViewModel = DeparturesViewModel(departuresUseCase, stationTimeFormatUseCase, dispatcher)
    }

    @Test
    fun `getDepartures() invokes getDepartures() in departuresUseCase`() {
        runBlocking {
            val data = listOf(DepartureEntity(DateTimeEntity(1461056400L, "GMT+02:00"), "L007", "Berlin"))
            `when`(departuresUseCase.getDepartures()).thenReturn(Results.Success(data))
            `when`(stationTimeFormatUseCase.getStationTime(any())).thenReturn("")
            departuresViewModel.getDepartures()
            verify(departuresUseCase).getDepartures()
        }
    }

    @Test
    fun `getDepartures() invokes getStationTime() in stationTimeFormatUseCase`() {
        runBlocking {
            val data = listOf(DepartureEntity(DateTimeEntity(1461056400L, "GMT+02:00"), "L007", "Berlin"))
            `when`(departuresUseCase.getDepartures()).thenReturn(Results.Success(data))
            `when`(stationTimeFormatUseCase.getStationTime(any())).thenReturn("")
            departuresViewModel.getDepartures()
            verify(stationTimeFormatUseCase).getStationTime(any())
        }
    }

    @Test
    fun `getDepartures() with Success invokes departuresLiveData`() {
        runBlocking {
            val data = listOf(DepartureEntity(DateTimeEntity(1461056400L, "GMT+02:00"), "L007", "Berlin"))
            `when`(departuresUseCase.getDepartures()).thenReturn(Results.Success(data))
            `when`(stationTimeFormatUseCase.getStationTime(any())).thenReturn("")
            departuresViewModel.departuresLiveData.observeForever(departuresObserver)
            departuresViewModel.getDepartures()
            verify(departuresObserver, times(1)).onChanged(any())
        }
    }

    @Test
    fun `getDepartures() with Error does not invoke getStationTime() in stationTimeFormatUseCase`() {
        runBlocking {
            `when`(departuresUseCase.getDepartures()).thenReturn(Results.Error(Throwable()))
            departuresViewModel.getDepartures()
            verify(stationTimeFormatUseCase, times(0)).getStationTime(any())
        }
    }

    @Test
    fun `getDepartures() with Error does not invoke departuresLiveData`() {
        runBlocking {
            `when`(departuresUseCase.getDepartures()).thenReturn(Results.Error(Throwable()))
            departuresViewModel.departuresLiveData.observeForever(departuresObserver)
            departuresViewModel.getDepartures()
            verify(departuresObserver, times(0)).onChanged(any())
        }
    }

    @Test
    fun `getDepartures() with Error invokes errorLiveData`() {
        runBlocking {
            `when`(departuresUseCase.getDepartures()).thenReturn(Results.Error(Throwable("")))
            departuresViewModel.errorLiveData.observeForever(errorObserver)
            departuresViewModel.getDepartures()
            verify(errorObserver, times(1)).onChanged("")
        }
    }

    @Test
    fun `getDepartures() with Success does not invoke errorLiveData`() {
        runBlocking {
            val data = listOf(DepartureEntity(DateTimeEntity(1461056400L, "GMT+02:00"), "L007", "Berlin"))
            `when`(departuresUseCase.getDepartures()).thenReturn(Results.Success(data))
            `when`(stationTimeFormatUseCase.getStationTime(any())).thenReturn("")
            departuresViewModel.errorLiveData.observeForever(errorObserver)
            departuresViewModel.getDepartures()
            verify(errorObserver, times(0)).onChanged(any())
        }
    }
}