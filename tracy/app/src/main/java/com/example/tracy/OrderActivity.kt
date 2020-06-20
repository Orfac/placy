package com.example.tracy

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class OrderActivity : AppCompatActivity() {
    lateinit var name : TextView
    lateinit var price : TextView
    lateinit var description : TextView
    lateinit var phone : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        name = findViewById(R.id.editTextTextPersonName)
        price = findViewById(R.id.editTextTextPrice)
        description = findViewById(R.id.editTextTextMultiLine)
        phone = findViewById(R.id.editTextPhone)


    }

    fun submit(view : View){
        val resultIntent = Intent()
        resultIntent.putExtra("name", name.text.toString())
        resultIntent.putExtra("price", price.text.toString())
        resultIntent.putExtra("phone", phone.text.toString())
        resultIntent.putExtra("description", description.text.toString())
        setResult(1, resultIntent)
        finish()
    }
}