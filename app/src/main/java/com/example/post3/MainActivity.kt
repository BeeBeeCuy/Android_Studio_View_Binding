package com.example.post3

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.post3.ResultActivity.Companion.AGE
import com.example.post3.ResultActivity.Companion.EMAIL
import com.example.post3.ResultActivity.Companion.FULL_NAME
import com.example.post3.ResultActivity.Companion.GENDER
import com.example.post3.ResultActivity.Companion.USERNAME
import com.example.post3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)



        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etAge = findViewById<EditText>(R.id.etAge)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        binding.apply {
            btnSubmit.setOnClickListener {
                val fullName = etFullName.text.toString()
                val username = etUsername.text.toString()
                val age = etAge.text.toString()
                val email = etEmail.text.toString()
                val selectedGenderId = rgGender.checkedRadioButtonId
                val password = etPassword.text.toString()
                val confirmPassword = etConfirmPassword.text.toString()


                if (fullName.isEmpty() || username.isEmpty() || age.isEmpty() || email.isEmpty() ||
                    selectedGenderId == -1 || password.isEmpty() || confirmPassword.isEmpty()
                ) {
                    Toast.makeText(this@MainActivity, "Please fill all fields", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (password != confirmPassword) {
                    Toast.makeText(this@MainActivity, "Passwords do not match", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val selectedGender = selectedGenderId.toString()


                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                .putExtra(FULL_NAME, fullName)
                .putExtra(USERNAME, username)
                .putExtra(AGE, age)
                .putExtra(EMAIL, email)
                .putExtra(GENDER, selectedGender)
                startActivity(intent)
            }
        }
    }
}
