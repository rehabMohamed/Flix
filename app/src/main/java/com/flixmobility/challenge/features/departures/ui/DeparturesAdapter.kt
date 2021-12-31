package com.flixmobility.challenge.features.departures.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flixmobility.challenge.R
import com.flixmobility.challenge.databinding.ListItemDepartureBinding
import com.flixmobility.challenge.features.departures.models.Departure
import javax.inject.Inject

class DeparturesAdapter @Inject constructor() : RecyclerView.Adapter<DeparturesAdapter.ViewHolder>() {

    private val dataSet = mutableListOf<Departure>()

    class ViewHolder(private val binding: ListItemDepartureBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(departure: Departure) {
            with(binding) {
                directionTv.text = departure.direction
                lineCodeTv.text = departure.lineCode
                timeTv.text = departure.time
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item_departure, viewGroup, false)
        val binding = ListItemDepartureBinding.bind(view)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    fun setData(departures: List<Departure>) {
        dataSet.clear()
        dataSet.addAll(departures)
        notifyDataSetChanged()
    }
}