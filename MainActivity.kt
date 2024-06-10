package com.example.imad5112examination

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // declaring the buttons
        val mainButton = findViewById<Button>(R.id.btnMain)
        val exitButton = findViewById<Button>(R.id.btnExit)

        mainButton.setOnClickListener{
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }
        exitButton.setOnClickListener{
            finish()
        }
    }
}