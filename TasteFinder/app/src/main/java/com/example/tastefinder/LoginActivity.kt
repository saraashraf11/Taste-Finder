package com.example.tastefinder

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText

    private lateinit var passwordEditText: EditText

    private lateinit var loginButton: Button
    private lateinit var facebookImageView: ImageView
    private lateinit var googleImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.Email_login)
        passwordEditText = findViewById(R.id.Password_login)
        facebookImageView = findViewById(R.id.facebook_login)
        googleImageView = findViewById(R.id.google_login)

        loginButton.setOnClickListener {
            loginUser()
        }

        // Set onClick listener for Facebook login
        facebookImageView.setOnClickListener {
            Toast.makeText(this, "Facebook Login", Toast.LENGTH_SHORT).show()
        }

        // Set onClick listener for Google login
        googleImageView.setOnClickListener {
            Toast.makeText(this, "Google Login", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loginUser() {

        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if ( email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
        } else {
            // Proceed with registration logic (e.g., sending data to a server or saving locally)
            Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
        }
    }
}