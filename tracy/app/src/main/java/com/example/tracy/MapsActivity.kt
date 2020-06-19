package com.example.tracy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.ArrayList

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var points : ArrayList<LatLng>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        points = ArrayList<LatLng>()
        // Add a marker in Saint Petersburg
        val saintPetersburgLocation = LatLng(59.932473, 30.349142)
        mMap.addMarker(MarkerOptions().position(saintPetersburgLocation).title("location is saint P"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(saintPetersburgLocation))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(saintPetersburgLocation, 12f))

        mMap.setOnMapLongClickListener {
            onClick(it)
        }
    }

    private fun onClick(location: LatLng) {
        if (points.size == 2) {
            points.clear()
            mMap.clear()
        }

        points.add(location)
        val marker = MarkerOptions()
        marker.position(location)

        if (points.size == 1) {
            val greenPointer =
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
            marker.icon(greenPointer)
        }
        mMap.addMarker(marker)

        if (points.size == 2){
                val url = getRequestUrl(points[0],points[1])
            }
    }

    private fun getRequestUrl(origin: LatLng, destination: LatLng): String {
            val originString = "origin=" + origin.latitude + ","+ origin.longitude
            return originString
    }

    fun doContent(view: View) {}
}
