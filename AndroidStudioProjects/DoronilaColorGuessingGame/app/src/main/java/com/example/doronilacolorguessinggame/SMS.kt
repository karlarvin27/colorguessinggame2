package com.example.doronilacolorguessinggame

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat

class SMS : AppCompatActivity() {

    private lateinit var phone: EditText
    private lateinit var send: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        phone = findViewById(R.id.phoneET)
        send = findViewById(R.id.sendSMSBtn)

        checkPermission()
        send.setOnClickListener{
            val phoneNumber = phone.text.toString()
            if(phoneNumber.isNotEmpty()){
                val sendIntent = Intent(Intent.ACTION_VIEW)
                sendIntent.data = Uri.parse("sms:$phoneNumber")
                startActivity(sendIntent)
            }
        }

    }

    private fun checkPermission() {
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)
            != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS),101)
        }
    }
}