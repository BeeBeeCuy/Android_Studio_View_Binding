package com.example.post3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.post3.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val fullName = intent.getStringExtra("FULL_NAME")
        val username = intent.getStringExtra("USERNAME")
        val age = intent.getStringExtra("AGE")
        val email = intent.getStringExtra("EMAIL")
        val gender = intent.getStringExtra("GENDER")

    }
    companion object{
        const val FULL_NAME = "fullname"
        const val USERNAME = "username"
        const val AGE = "age"
        const val EMAIL = "email"
        const val GENDER = "selectedgender"

    }
}
