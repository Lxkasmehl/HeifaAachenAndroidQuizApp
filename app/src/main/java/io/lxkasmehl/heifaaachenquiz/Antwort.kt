package io.lxkasmehl.heifaaachenquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Antwort : AppCompatActivity(), View.OnClickListener {
    var btnWeiter: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_antwort)

        btnWeiter = findViewById<View>(R.id.btnWeiter) as Button
        btnWeiter!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent = Intent(application, Spiel::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}