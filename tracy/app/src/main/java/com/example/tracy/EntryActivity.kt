package com.example.tracy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EntryActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        val clientButton = findViewById<Button>(R.id.client)
        clientButton.setOnClickListener {
            onClient()
        }

        val driverButton = findViewById<Button>(R.id.driver)
        driverButton.setOnClickListener {
            onDriver()
        }

        val aboutButton = findViewById<Button>(R.id.about)
        aboutButton.setOnClickListener {
            onAbout()
        }
    }

    private fun onAbout() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    private fun onDriver() {
        val intent = Intent(this, DriverActivity::class.java)
        startActivity(intent)
    }

    private fun onClient() {
        val intent = Intent(this, ClientActivity::class.java)
        startActivity(intent)
    }
}