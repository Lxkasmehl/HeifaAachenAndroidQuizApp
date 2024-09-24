package my.awesome.htfquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class activity_eq : AppCompatActivity(), View.OnClickListener {
    var wV_eq: WebView? = null
    var iB_back: ImageButton? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eq)

        wV_eq = findViewById<View>(R.id.wV_eq) as WebView
        wV_eq!!.settings.domStorageEnabled = true
        wV_eq!!.settings.javaScriptEnabled = true
        wV_eq!!.clearCache(true)
        wV_eq!!.loadUrl("https://quiz.heiligtumsfahrt-aachen.de/vq.php")

        iB_back = findViewById<View>(R.id.iB_back) as ImageButton
        iB_back!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val ADB = AlertDialog.Builder(this)

        ADB.setTitle("Video-Quiz beenden?")

        //ADB.setIcon();
        ADB.setMessage("Bist du sicher, dass du das Video-Quiz beenden willst?")

        ADB.setCancelable(false)

        ADB.setPositiveButton(
            "Ja"
        ) { dialogInterface, i ->
            wV_eq!!.onPause()
            wV_eq!!.reload()

            val first_intent = Intent(
                application,
                MainActivity::class.java
            )
            startActivity(first_intent)
        }

        ADB.setNegativeButton(
            "Nein"
        ) { dialogInterface, i ->
            Toast.makeText(
                this@activity_eq,
                "Setze das Quiz fort",
                Toast.LENGTH_LONG
            ).show()
        }

        val alertDialog = ADB.create()
        alertDialog.show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val ADB = AlertDialog.Builder(this)

        ADB.setTitle("Video-Quiz beenden?")

        //ADB.setIcon();
        ADB.setMessage("Bist du sicher, dass du das Video-Quiz beenden willst?")

        ADB.setCancelable(false)

        ADB.setPositiveButton(
            "Ja"
        ) { dialogInterface, i ->
            wV_eq!!.onPause()
            wV_eq!!.reload()

            val first_intent = Intent(
                application,
                MainActivity::class.java
            )
            startActivity(first_intent)
        }

        ADB.setNegativeButton(
            "Nein"
        ) { dialogInterface, i ->
            Toast.makeText(
                this@activity_eq,
                "Setze das Quiz fort",
                Toast.LENGTH_LONG
            ).show()
        }

        val alertDialog = ADB.create()
        alertDialog.show()
    }

    public override fun onPause() {
        super.onPause()
        wV_eq!!.onPause()
        wV_eq!!.reload()
    }
}