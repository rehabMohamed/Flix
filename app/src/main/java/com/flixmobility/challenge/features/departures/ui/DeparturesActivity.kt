package com.flixmobility.challenge.features.departures.ui

import android.os.Bundle
import android.util.Log
import com.flixmobility.challenge.databinding.ActivityDeparturesBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DeparturesActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModel : DeparturesViewModel
    private lateinit var binding: ActivityDeparturesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeparturesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addObservers()

        getDepartures()
    }

    private fun getDepartures() {
        viewModel.getDepartures()
    }

    private fun addObservers() {
        viewModel.departuresLiveData.observe(this, { departures ->
            Log.d("departures", departures.toString())
        })

        viewModel.errorLiveData.observe(this, { message ->
            Log.d("error", message)
        })
    }
}