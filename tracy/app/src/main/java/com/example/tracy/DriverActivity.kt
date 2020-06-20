package com.example.tracy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import java.util.ArrayList

class DriverActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val saintPetersburgLocation = LatLng(59.932473, 30.349142)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(saintPetersburgLocation))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(saintPetersburgLocation, 12f))
        mMap.uiSettings.isMapToolbarEnabled = false
    }

}