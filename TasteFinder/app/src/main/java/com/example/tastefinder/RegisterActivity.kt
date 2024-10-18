package com.example.tastefinder

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var facebookImageView: ImageView
    private lateinit var googleImageView: ImageView
    private lateinit var backButton :ImageButton
    private lateinit var firebaseAuth: FirebaseAuth

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
        backButton = findViewById(R.id.buttonBack)
        firebaseAuth = FirebaseAuth.getInstance()

        backButton.setOnClickListener{
            val intent = Intent(this, EnteryActivity::class.java)
            startActivity(intent)
        }

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

        if(name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
            if(password == confirmPassword) {

                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful) {
                        Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)

                    }else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            }
        }else {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }
}
