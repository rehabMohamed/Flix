package com.flixmobility.challenge.features.departures.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flixmobility.challenge.domain.entity.DepartureEntity
import com.flixmobility.challenge.domain.entity.Results
import com.flixmobility.challenge.domain.usecase.DeparturesUseCase
import com.flixmobility.challenge.domain.usecase.StationTimeFormatUseCase
import com.flixmobility.challenge.features.departures.models.Departure
import com.flixmobility.challenge.utils.Dispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeparturesViewModel @Inject constructor(
    private val departuresUseCase: DeparturesUseCase,
    private val stationTimeFormatUseCase: StationTimeFormatUseCase,
    private val dispatcher: Dispatcher
) : ViewModel() {

    private val _departuresLiveData = MutableLiveData<List<Departure>>()
    val departuresLiveData: LiveData<List<Departure>> =_departuresLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> =_errorLiveData

    fun getDepartures(){
        viewModelScope.launch(dispatcher.io()) {
            when (val results = departuresUseCase.getDepartures()) {
                is Results.Success<List<DepartureEntity>> -> {
                    _departuresLiveData.postValue(results.data.map { toDeparture(it) })
                }
                is Results.Error -> {
                    _errorLiveData.postValue(results.throwable.message)
                }
            }
        }
    }

    private fun toDeparture(departureEntity: DepartureEntity): Departure{
        return Departure(
            time = stationTimeFormatUseCase.getStationTime(departureEntity.dateTimeEntity),
            lineCode = departureEntity.lineCode,
            direction = departureEntity.direction
        )
    }
}