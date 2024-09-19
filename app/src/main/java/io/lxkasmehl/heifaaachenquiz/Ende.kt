package io.lxkasmehl.heifaaachenquiz

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Ende : Activity(), View.OnClickListener {
    var btnStartseite: Button? = null
    var tVHighscoreAnzeige: TextView? = null
    var Highscore: TextView? = null

    var preferences: SharedPreferences? = null
    var preferencesEditor: SharedPreferences.Editor? = null

    var erreichtePunkte: Int = 0
    val KEY: String = "speicherPreferences"

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ende)

        btnStartseite = findViewById<View>(R.id.btnStartseite) as Button
        btnStartseite!!.setOnClickListener(this)

        tVHighscoreAnzeige = findViewById<View>(R.id.tVHighscoreAnzeige) as TextView
        Highscore = findViewById<View>(R.id.Highscore) as TextView

        this.preferences = this.getSharedPreferences("highscore", MODE_PRIVATE)
        preferences?.let { prefs ->
            preferencesEditor = prefs.edit()
        }

        val extras = intent.extras
        erreichtePunkte = extras?.getInt("Punkte") ?: 0

        punkteAnzeigen()
    }

    private fun punkteAnzeigen() {
        if (preferences!!.getInt(KEY, 0) < erreichtePunkte) {
            tVHighscoreAnzeige!!.text = "" + erreichtePunkte

            preferencesEditor!!.putInt(KEY, erreichtePunkte)

            //Highscore.setText("HIGHSCORE!");
        } else {
            tVHighscoreAnzeige!!.text = "" + erreichtePunkte
        }
    }

    override fun onClick(view: View) {
        val intent = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intent)
        this.finish()
    }

    override fun onBackPressed() {
        val first_intent = Intent(
            application,
            MainActivity::class.java
        )
        startActivity(first_intent)
    }
}