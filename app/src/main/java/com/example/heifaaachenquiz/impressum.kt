package com.example.heifaaachenquiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.heifaaachenquiz.R

class impressum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_impressum)
    }

    override fun onBackPressed() {
        val first_intent = Intent(
            application,
            MainActivity::class.java
        )
        startActivity(first_intent)
    }
}