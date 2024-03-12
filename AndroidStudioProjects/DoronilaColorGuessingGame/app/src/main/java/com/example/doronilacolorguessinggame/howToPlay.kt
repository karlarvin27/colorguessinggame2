package com.example.doronilacolorguessinggame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class howToPlay : AppCompatActivity() {

    private lateinit var backToHomeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.howto_play)

        backToHomeButton = findViewById(R.id.backToHome)
        backToHomeButton.setOnClickListener{
            val backToHomeIntent = Intent(this, HomeActivity::class.java)
            startActivity(backToHomeIntent)
            finish()

        }
    }
}