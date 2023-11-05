package com.example.miu_mobile_assignemnt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerButton = findViewById<Button>(R.id.createUser)
        registerButton.setOnClickListener {
            val firstname = findViewById<EditText>(R.id.firstname)
            val lastname = findViewById<EditText>(R.id.lastname)
            val username = findViewById<EditText>(R.id.userEmail)
            val password = findViewById<EditText>(R.id.userPassword)
            createUser(firstname.text.toString(), lastname.text.toString(), username.text.toString(), password.text.toString())
        }
    }
    private fun createUser(firstname: String, lastname: String, email: String, password: String) {
        if (firstname.isNotEmpty() && lastname.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            print("register user");

        } else {
            Toast.makeText(this, "Add required fields", Toast.LENGTH_SHORT).show()
        }
    }
}