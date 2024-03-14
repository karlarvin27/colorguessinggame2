package com.example.doronilacolorguessinggame

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Browser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        val btnOpenURL: Button = findViewById(R.id.btnOpenURL)
        val urlEditText: EditText = findViewById(R.id.urlEditText)

        // Handle "Enter" key press
        urlEditText.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                openUrl(urlEditText.text.toString())
                urlEditText.text.clear()
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }

        btnOpenURL.setOnClickListener {
            openUrl(urlEditText.text.toString())
            urlEditText.text.clear()
        }
    }

    private fun openUrl(url: String) {
        if (url.isNotEmpty()) {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://$url")
            startActivity(openURL)
        } else {
            Toast.makeText(this, "Please enter a valid URL", Toast.LENGTH_LONG).show()
        }
    }
}
