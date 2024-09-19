package io.lxkasmehl.heifaaachenquiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class impressum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_impressum)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val first_intent = Intent(
            application,
            MainActivity::class.java
        )
        startActivity(first_intent)
    }
}