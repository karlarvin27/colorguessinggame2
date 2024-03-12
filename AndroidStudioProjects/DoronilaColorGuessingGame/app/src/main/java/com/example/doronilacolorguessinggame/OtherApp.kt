package com.example.doronilacolorguessinggame

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class OtherApp : AppCompatActivity() {

    private lateinit var backOtherToHomeButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_app)

        backOtherToHomeButton = findViewById<Button>(R.id.otherAppBackButton)
        backOtherToHomeButton.setOnClickListener{
            val backOtherToHomeIntent = Intent(this, HomeActivity::class.java)
            startActivity(backOtherToHomeIntent)
            finish()

        }
        val phoneImageView = findViewById<ImageButton>(R.id.imagePhoneButton)
        phoneImageView.setOnClickListener {
            // Your intent code here
            val phoneIntent = Intent(this, Phone::class.java)
            startActivity(phoneIntent)
        }
        val mapImageView = findViewById<ImageButton>(R.id.imageMapButton)
        mapImageView.setOnClickListener {
            // Your intent code here
            val phoneIntent = Intent(this, Phone::class.java)
            startActivity(phoneIntent)
        }


    }

    }
