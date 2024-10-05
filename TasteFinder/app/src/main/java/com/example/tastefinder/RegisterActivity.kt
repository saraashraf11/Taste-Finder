package com.example.tastefinder

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var facebookImageView: ImageView
    private lateinit var googleImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize views
        nameEditText = findViewById(R.id.name)
        emailEditText = findViewById(R.id.email)
        phoneEditText = findViewById(R.id.phone)
        passwordEditText = findViewById(R.id.password)
        confirmPasswordEditText = findViewById(R.id.confirmPassword)
        registerButton = findViewById(R.id.registerBtn)
        facebookImageView = findViewById(R.id.facebook)
        googleImageView = findViewById(R.id.google)

        // Set onClick listener for register button
        registerButton.setOnClickListener {
            registerUser()
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

    private fun registerUser() {
        val name = nameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val phone = phoneEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        val confirmPassword = confirmPasswordEditText.text.toString().trim()

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
        } else if (password != confirmPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
        } else {
            // Proceed with registration logic (e.g., sending data to a server or saving locally)
            Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
        }
    }
}
