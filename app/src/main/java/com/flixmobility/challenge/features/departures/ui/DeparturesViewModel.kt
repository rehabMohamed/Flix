package com.flixmobility.challenge.features.departures.ui

import androidx.lifecycle.ViewModel
import com.flixmobility.challenge.domain.usecase.DeparturesUseCase
import javax.inject.Inject

class DeparturesViewModel @Inject constructor(
    private val departuresUseCase: DeparturesUseCase
) : ViewModel()