package com.example.tracy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tracy.infowindows.CustomInfoWindow
import com.example.tracy.model.CustomDataProvider
import com.example.tracy.model.InfoWindowData
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.ArrayList

class DriverActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    public lateinit var initializedData : List<InfoWindowData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        initializedData = CustomDataProvider.getData()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val saintPetersburgLocation = LatLng(59.932473, 30.349142)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(saintPetersburgLocation))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(saintPetersburgLocation, 12f))
        mMap.uiSettings.isMapToolbarEnabled = false

        val customInfoWindow = CustomInfoWindow(this)
        mMap.setInfoWindowAdapter(customInfoWindow)

        var index = 0
        initializedData.forEach{
            val markerOptions = MarkerOptions().position(it.location).title("Заказ №${index}")
            val marker = mMap.addMarker(markerOptions)
            marker.tag = it
            marker.showInfoWindow()
            index += 1
        }



    }



}