package com.example.tracy

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tracy.infowindows.CustomInfoWindow
import com.example.tracy.model.InfoWindowData
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*


class ClientActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var points: ArrayList<LatLng>
    private lateinit var fab: FloatingActionButton
    private lateinit var bufferedPoint: LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        fab = this.findViewById(R.id.fab)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        points = ArrayList()
        // Add a marker in Saint Petersburg
        val saintPetersburgLocation = LatLng(59.932473, 30.349142)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(saintPetersburgLocation))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(saintPetersburgLocation, 12f))
        mMap.uiSettings.isMapToolbarEnabled = false
        mMap.setOnMapClickListener {
            onClick(it)
        }
        val customInfoWindow = CustomInfoWindow(this)
        mMap.setInfoWindowAdapter(customInfoWindow)
    }

    private fun onClick(location: LatLng) {
        if (points.size == 2) {
            points.clear()
            mMap.clear()
            fab.visibility = GONE
        }
        if (points.size == 1) {
            fab.visibility = VISIBLE
        }
        val label = if (points.size == 0) "Откуда" else "Куда"
        points.add(location)
        val marker = MarkerOptions()

        marker.position(location).title(label)

        mMap.addMarker(marker)
    }


    fun addOrder(view: View) {
        val intent = Intent(this, OrderActivity::class.java)
        val bundle = Bundle()
        bufferedPoint = points[0]
        startActivityForResult(intent, 1, bundle)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 1) {
            val name = data?.getStringExtra("name").toString()
            val price = data?.getStringExtra("price").toString()
            val phone = data?.getStringExtra("phone").toString()
            val description = data?.getStringExtra("description").toString()
            points.clear()
            mMap.clear()

            val infoWindowData =
                InfoWindowData(bufferedPoint, phone, description, price, name)

            val markerOptions = MarkerOptions().position(infoWindowData.location)
            val marker = mMap.addMarker(markerOptions)
            marker.tag = infoWindowData
            marker.showInfoWindow()
        }
    }
}
