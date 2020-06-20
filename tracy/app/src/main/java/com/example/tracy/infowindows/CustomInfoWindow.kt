package com.example.tracy.infowindows

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.TextView
import com.example.tracy.R
import com.example.tracy.model.InfoWindowData
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class CustomInfoWindow(val context: Context) : GoogleMap.InfoWindowAdapter {

    override fun getInfoContents(location: Marker?): View? {
        val view = (context as Activity)
            .layoutInflater.inflate(R.layout.info_window_layout, null)

        var head =  view.findViewById<TextView>(R.id.title)
        var phone = view.findViewById<TextView>(R.id.phone)
        var description = view.findViewById<TextView>(R.id.description)

        val infoData = location?.tag as InfoWindowData
        head.setText(infoData.)
    }

    override fun getInfoWindow(location: Marker?): View? {
        return null
    }
}