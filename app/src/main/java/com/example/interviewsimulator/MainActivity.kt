package com.example.interviewsimulator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textButton: Button = findViewById(R.id.textButton)
        val videoButton: Button = findViewById(R.id.videoButton)

        textButton.setOnClickListener {
            val intent = Intent(this, InterviewActivity::class.java)
            intent.putExtra("responseType", "text")
            startActivity(intent)
        }

        videoButton.setOnClickListener {
            val intent = Intent(this, InterviewActivity::class.java)
            intent.putExtra("responseType", "video")
            startActivity(intent)
        }
    }
}