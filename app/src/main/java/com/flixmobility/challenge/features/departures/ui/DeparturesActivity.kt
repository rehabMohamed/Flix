package com.flixmobility.challenge.features.departures.ui

import android.os.Bundle
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

    }

    private fun addObservers() {

    }
}