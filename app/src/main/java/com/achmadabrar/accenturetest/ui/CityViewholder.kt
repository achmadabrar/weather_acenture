package com.achmadabrar.accenturetest.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.achmadabrar.accenturetest.data.models.AreaName
import kotlinx.android.synthetic.main.item_city.view.*

class CityViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(areaName: AreaName, listener: Listener?) {
        with(itemView) {
            if (areaName.cdata != null) {
                text_view_city_name.text = areaName.cdata
                itemView.setOnClickListener {
                    listener?.onClickArea(areaName)
                }
            }
        }
    }

    interface Listener {
        fun onClickArea(areaName: AreaName)
    }
}