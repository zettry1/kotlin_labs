package com.example.miu_mobile_assignemnt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.miu_mobile_assignemnt.modal.User

class MainActivity : AppCompatActivity() {
    private val user1= User("john","doe","john@gmail.com","123")
    private val user2= User("bold","doe","bold@gmail.com","322")
    private val user3= User("dove","doe","dove@gmail.com","333")
    private val user4= User("erin","doe","erin@gmail.com","123123")
    private val user5= User("armin","armin","armin@gmail.com","323232")

    val dbusers = mutableListOf<User>(user1,user2,user3,user4,user5)
    private val mainUser:User? = null;
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val login = findViewById<Button>(R.id.signIn)
        val forgot = findViewById<TextView>(R.id.forgotPassword)
        val register = findViewById<TextView>(R.id.register)

        login.setOnClickListener {
            val username = findViewById<EditText>(R.id.username)
            val password = findViewById<EditText>(R.id.password)
            if (username.text.isNotEmpty() && password.text.isNotEmpty()) {
                loginFunction(username.text.toString(), password.text.toString())
            }
        }

        forgot.setOnClickListener {
            val inputUserName = findViewById<EditText>(R.id.username)
            if (inputUserName.text.isNotEmpty()) {
                val found = dbusers.find { it.email == inputUserName.text.toString() }
                if (found != null) {
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Your password is " + found.pass)
                        type = "text/plain"
                    }
                    val shareIntent = Intent.createChooser(sendIntent, null)
                    startActivity(shareIntent)
                } else {
                    Toast.makeText(this, "User not found!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Fill the email field.", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun loginFunction(username: String, password: String): Boolean {
        val loginUser = dbusers.find { it.email == username && it.pass == password}
        if (loginUser != null) {
            var mainUser = loginUser
            Toast.makeText(this, "Welcome! " + loginUser.firstname, Toast.LENGTH_SHORT).show()
            println(loginUser.toString())
            val intent = Intent(this, ShoppingActivity::class.java)
            intent.putExtra("email", loginUser.email)
            startActivity(intent)
        } else {
            Toast.makeText(this, "User not found.", Toast.LENGTH_SHORT).show()
        }
        return loginUser != null
    }


}