package com.example.tracy.model

import com.google.android.gms.maps.model.LatLng

data class InfoWindowData(
    val location: LatLng,
    val phone: String,
    val description: String,
    val price: String,
    val name: String
)