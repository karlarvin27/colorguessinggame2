package com.example.doronilacolorguessinggame

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception

class Email : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        val recipientEditText = findViewById<EditText>(R.id.toEditText)
        val subjectEditText = findViewById<EditText>(R.id.subjectEditText)
        val messageEditText = findViewById<EditText>(R.id.messageEditText)
        val sendEmailBtn = findViewById<Button>(R.id.emailSendButton)


        sendEmailBtn.setOnClickListener{
            val recipient = recipientEditText.text.toString().trim()
            val subject = subjectEditText.text.toString().trim()
            val message = messageEditText.text.toString().trim()

            val mIntent = Intent(Intent.ACTION_SEND)

            mIntent.data = Uri.parse("mailto")
            mIntent.type = "text/plain"
            mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            mIntent.putExtra(Intent.EXTRA_TEXT, message)

            try{
                startActivity(Intent.createChooser(mIntent, "Send Email"))
            }catch(e: Exception){
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }


        }

    }
}