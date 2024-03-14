package com.example.doronilacolorguessinggame


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton


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
        val phoneImageView = findViewById<ImageButton>(R.id.phoneBtn)
        phoneImageView.setOnClickListener {
            // Your intent code here
            val phoneIntent = Intent(this, Phone::class.java)
            startActivity(phoneIntent)
        }
        val mapImageView = findViewById<ImageButton>(R.id.mapsBtn)
            mapImageView.setOnClickListener {
            // Your intent code here
            val mapsIntent = Intent(this, Maps::class.java)
            startActivity(mapsIntent)
        }
        val smsImageView = findViewById<ImageButton>(R.id.smsBtn)
            smsImageView.setOnClickListener {
            // Your intent code here
            val smsIntent = Intent(this, SMS::class.java)
            startActivity(smsIntent)
        }
        val browserImageView = findViewById<ImageButton>(R.id.browserBtn)
            browserImageView.setOnClickListener {
            // Your intent code here
            val browserIntent = Intent(this, Browser::class.java)
            startActivity(browserIntent)
        }
        val emailImageView = findViewById<ImageButton>(R.id.emailBtn)
            emailImageView.setOnClickListener {
            // Your intent code here
            val emailIntent = Intent(this, Email::class.java)
            startActivity(emailIntent)
        }

        val galleryImageView = findViewById<ImageButton>(R.id.galleryBtn)
            galleryImageView.setOnClickListener {
            // Your intent code here
            val GalleryIntent = Intent(this, Gallery::class.java)
            startActivity(GalleryIntent)
        }



    }

    }
