package my.awesome.htfquiz

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var btnSpielen: Button? = null
    var btnSpielen2: Button? = null
    var btnimpressum: Button? = null
    var btndatenschutz: Button? = null

    var pressedOnce: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSpielen = findViewById<View>(R.id.btnSpielen) as Button
        btnSpielen!!.setOnClickListener(this)

        btnSpielen2 = findViewById<View>(R.id.btnSpielen2) as Button
        btnSpielen2!!.setOnClickListener(this)

        btnimpressum = findViewById<View>(R.id.impressum) as Button
        btnimpressum!!.setOnClickListener(this)

        btndatenschutz = findViewById<View>(R.id.datenschutz) as Button
        btndatenschutz!!.setOnClickListener(this)
    }

    /*@Override
    public void onClick(View view) {
        Intent intent = new Intent (this, Spiel.class);
        startActivity(intent);
        this.finish();
    }*/
    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnSpielen -> {
                val intent = Intent(
                    this,
                    Spiel::class.java
                )
                startActivity(intent)
                this.finish()
            }
            R.id.btnSpielen2 -> {
                val intent = Intent(
                    this,
                    activity_eq::class.java
                )
                startActivity(intent)
                this.finish()
            }
            R.id.impressum -> {
                val intent = Intent(
                    this,
                    impressum::class.java
                )
                startActivity(intent)
                this.finish()
            }
            R.id.datenschutz -> {
                val intent = Intent(
                    this,
                    datenschutz::class.java
                )
                startActivity(intent)
                this.finish()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (!pressedOnce) {
            pressedOnce = true
            Toast.makeText(applicationContext, "Erneut drücken, um zu beenden.", Toast.LENGTH_SHORT)
                .show()

            Handler().postDelayed({ pressedOnce = false }, 3000)
        } else if (pressedOnce) {
            pressedOnce = false
            moveTaskToBack(false)
            //onBackPressed();
        }
    }
}