package com.example.interviewsimulator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.content.Intent

class NextQuestionActivity : AppCompatActivity() {
    private lateinit var questionText: TextView
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_question)

        questionText = findViewById(R.id.questionText)
        continueButton = findViewById(R.id.continueButton)

        questionText.text = "¿Cuál es tu mayor debilidad?" // Example next question

        continueButton.setOnClickListener {
            // Logic to continue to the next question or finish the interview
            // For now, we can just finish the activity
            finish()
        }
    }
}