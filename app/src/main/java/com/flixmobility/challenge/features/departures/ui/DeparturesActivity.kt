package com.flixmobility.challenge.features.departures.ui

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import com.flixmobility.challenge.databinding.ActivityDeparturesBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DeparturesActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModel : DeparturesViewModel
    @Inject
    lateinit var departuresAdapter: DeparturesAdapter
    private lateinit var binding: ActivityDeparturesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeparturesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.apply {
            adapter = departuresAdapter
            addItemDecoration(DividerItemDecoration(context, VERTICAL))
        }
        addObservers()
        getDepartures()
    }

    private fun getDepartures() {
        binding.progressBar.visibility = VISIBLE
        viewModel.getDepartures()
    }

    private fun addObservers() {
        viewModel.departuresLiveData.observe(this, { departures ->
            departuresAdapter.setData(departures)
            binding.progressBar.visibility = GONE
        })

        viewModel.errorLiveData.observe(this, { message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            binding.progressBar.visibility = GONE
        })
    }
}