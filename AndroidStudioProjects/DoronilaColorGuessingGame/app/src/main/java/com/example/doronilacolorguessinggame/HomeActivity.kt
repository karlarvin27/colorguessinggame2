package com.example.doronilacolorguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent


// HomeActivity.kt
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val startGameButton = findViewById<Button>(R.id.startGameButton)
        startGameButton.setOnClickListener {
            // Start the color guessing game (MainActivity)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val howToPlayButton = findViewById<Button>(R.id.howToPlayButton)
        howToPlayButton.setOnClickListener {
            // Redirect to How to Play Page
            val howToPlayIntent = Intent(this, howToPlay::class.java)
            startActivity(howToPlayIntent)
        }

        val otherAppButton = findViewById<Button>(R.id.otherAppButton)
        otherAppButton.setOnClickListener {
            // Redirect to Other App Menu
            val otherAppButtonIntent = Intent(this, OtherApp::class.java)
            startActivity(otherAppButtonIntent)
        }

    }
}
