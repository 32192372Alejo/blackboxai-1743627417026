package com.example.interviewsimulator

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class InterviewActivity : AppCompatActivity() {
    private lateinit var questionText: TextView
    private lateinit var continueButton: Button
    private var responseType: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview)

        questionText = findViewById(R.id.questionText)
        continueButton = findViewById(R.id.continueButton)

        responseType = intent.getStringExtra("responseType")

        if (responseType == "text") {
            setupTextInterview()
        } else if (responseType == "video") {
            requestCameraPermission()
        }
    }

    private fun setupTextInterview() {
        questionText.text = "¿Cuál es tu mayor fortaleza?" // Example question
        continueButton.setOnClickListener {
            // Logic to continue to the next question
        }
    }

    private fun requestCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 100)
        } else {
            startVideoInterview()
        }
    }

    private lateinit var cameraView: CameraView // Assuming a CameraView library is used

    private fun startVideoInterview() {
        // Initialize camera view and start recording
        cameraView = findViewById(R.id.cameraView)
        cameraView.visibility = View.VISIBLE
        // Start recording logic here
        cameraView.start() // Assuming a method to start the camera
        // Logic to stop recording
        cameraView.stop() // Assuming a method to stop the camera
        // Transition to the next question
        val intent = Intent(this, NextQuestionActivity::class.java) // Assuming a NextQuestionActivity exists
        startActivity(intent)
        // Logic to start video interview
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startVideoInterview()
            } else {
                Toast.makeText(this, "Permiso de cámara denegado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}