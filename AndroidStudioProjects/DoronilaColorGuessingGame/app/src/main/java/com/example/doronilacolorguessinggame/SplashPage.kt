package com.example.doronilacolorguessinggame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashPage : AppCompatActivity() {
    private lateinit var ivSplash: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_page)

        ivSplash = findViewById(R.id.ivSplash)
        ivSplash.alpha = 0f
        ivSplash.animate().setDuration(2000).alpha(1f).withEndAction {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}


