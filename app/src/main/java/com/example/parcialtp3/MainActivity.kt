package com.example.parcialtp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.buttonLogin)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, BottomNavigationActivity::class.java)
            startActivity(intent)
        }

    }
}