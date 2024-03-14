package com.example.doronilacolorguessinggame

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Phone : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)

        val etNumber: EditText=findViewById(R.id.etNumber)
        val btnDial: Button=findViewById(R.id.btnDial)

        btnDial.setOnClickListener{
            val num=etNumber.text.toString()
            if(num.isNotEmpty()) {
                //creating a call using intent
                val callIntent=Intent(Intent.ACTION_DIAL)
                //passing number from user
                callIntent.data = Uri.parse("tel: +$num")
                startActivity(callIntent)
            }
            else{
                Toast.makeText(this,"Kindly enter a legit number", Toast.LENGTH_LONG).show()
            }
        }
    }
}