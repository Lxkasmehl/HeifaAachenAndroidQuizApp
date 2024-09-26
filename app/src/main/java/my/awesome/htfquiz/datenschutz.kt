package my.awesome.htfquiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class datenschutz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datenschutz)
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