package com.example.tastefinder

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tastefinder.databinding.ActivityEnteryBinding
import com.example.tastefinder.databinding.ActivityMainBinding

class EnteryActivity : AppCompatActivity() {

    // Declare binding object
    private lateinit var binding: ActivityEnteryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize binding
        binding = ActivityEnteryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up button listeners using binding
        binding.signUpBtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.logInBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
