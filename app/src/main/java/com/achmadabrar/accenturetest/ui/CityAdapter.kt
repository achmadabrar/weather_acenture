package com.achmadabrar.accenturetest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.achmadabrar.accenturetest.R
import com.achmadabrar.accenturetest.data.models.AreaName

class CityAdapter(
    val listener: CityViewholder.Listener? = null,
    val areas: List<AreaName>
): RecyclerView.Adapter<CityViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewholder {
        return CityViewholder(LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false))
    }

    override fun onBindViewHolder(holder: CityViewholder, position: Int) {
        areas.get(position).let {
            holder.bind(it, listener)
        }
    }

    override fun getItemCount(): Int {
        return areas.size
    }
}