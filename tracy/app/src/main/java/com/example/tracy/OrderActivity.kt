package com.example.tracy

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text
import java.lang.IllegalStateException
import kotlin.properties.Delegates

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
        val errorView = findViewById<TextView>(R.id.errorMessage)
        errorView.visibility = View.GONE
        try {
            checkAllRequiredFieldsAreNotEmpty()
        } catch (ex : IllegalStateException){
            if (ex.message == "Order name should not be empty" ||
                    ex.message == "Phone should not be empty"){
                errorView.visibility = View.VISIBLE
                return
            }
        }

        val resultIntent = buildIntent()
        setResult(1, resultIntent)
        finish()
    }

    private fun buildIntent(): Intent {
        val resultIntent = Intent()
        resultIntent.putExtra("name", name.text.toString())
        resultIntent.putExtra("price", price.text.toString())
        resultIntent.putExtra("phone", phone.text.toString())
        resultIntent.putExtra("description", description.text.toString())
        return resultIntent
    }

    private fun checkAllRequiredFieldsAreNotEmpty() {
        val nameValue = name.text
        if (nameValue.isNullOrEmpty()) {
            throw IllegalStateException("Order name should not be empty")
        }

        val phoneValue = phone.text
        if (phoneValue.isNullOrEmpty()) {
            throw IllegalStateException("Phone should not be empty")
        }

    }
}