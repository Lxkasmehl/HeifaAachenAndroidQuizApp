package com.example.heifaaachenquiz

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout

class Spiel : Activity(), View.OnClickListener {
    var btnAntwortEins: Button? = null
    var btnAntwortZwei: Button? = null
    var btnAntwortDrei: Button? = null
    var btnAntwortVier: Button? = null
    var btnWeiter: Button? = null

    var tVAnzeigeFrage: TextView? = null
    var tVScore: TextView? = null
    var textView2: TextView? = null
    var textView4: TextView? = null

    var imageView: ImageView? = null

    var relativeLayout: ConstraintLayout? = null
    var relativeLayout2: ConstraintLayout? = null

    var aktuelleFrage: Int = 0
    var punkte: Int = 0
    var richtigFalsch: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spiel)

        btnAntwortEins = findViewById<View>(R.id.btnAntwortEins) as Button
        btnAntwortZwei = findViewById<View>(R.id.btnAntwortZwei) as Button
        btnAntwortDrei = findViewById<View>(R.id.btnAntwortDrei) as Button
        btnAntwortVier = findViewById<View>(R.id.btnAntwortVier) as Button
        btnWeiter = findViewById<View>(R.id.btnWeiter) as Button

        tVAnzeigeFrage = findViewById<View>(R.id.tVAnzeigeFrage) as TextView
        tVScore = findViewById<View>(R.id.tVScore) as TextView
        textView2 = findViewById<View>(R.id.textView2) as TextView
        textView4 = findViewById<View>(R.id.textView4) as TextView

        imageView = findViewById<View>(R.id.imageView) as ImageView

        relativeLayout = findViewById<View>(R.id.relativeLayout) as ConstraintLayout
        relativeLayout2 = findViewById<View>(R.id.relativeLayout2) as ConstraintLayout

        btnAntwortEins!!.setOnClickListener(this)
        btnAntwortZwei!!.setOnClickListener(this)
        btnAntwortDrei!!.setOnClickListener(this)
        btnAntwortVier!!.setOnClickListener(this)
        btnWeiter!!.setOnClickListener(this)

        relativeLayout!!.bringToFront()
        frageLaden()
    }

    private fun frageLaden() {
        val fragenC = Fragen()
        val fragen: ArrayList<Array<String?>> = fragenC.fragen
        val frage = fragen[aktuelleFrage]

        tVAnzeigeFrage!!.text = frage[0]

        val zufallszahl = (Math.random() * (4 - 1) + 1).toInt()

        when (zufallszahl) {
            1 -> {
                btnAntwortEins!!.text = frage[1]
                btnAntwortZwei!!.text = frage[2]
                btnAntwortDrei!!.text = frage[3]
                btnAntwortVier!!.text = frage[4]
            }

            2 -> {
                btnAntwortEins!!.text = frage[4]
                btnAntwortZwei!!.text = frage[1]
                btnAntwortDrei!!.text = frage[2]
                btnAntwortVier!!.text = frage[3]
            }

            3 -> {
                btnAntwortEins!!.text = frage[3]
                btnAntwortZwei!!.text = frage[4]
                btnAntwortDrei!!.text = frage[1]
                btnAntwortVier!!.text = frage[2]
            }

            4 -> {
                btnAntwortEins!!.text = frage[2]
                btnAntwortZwei!!.text = frage[3]
                btnAntwortDrei!!.text = frage[4]
                btnAntwortVier!!.text = frage[1]
            }
        }
        tVScore!!.text = "Punkte: $punkte"
    }

    fun antwortAnzeigen() {
        relativeLayout2!!.bringToFront()

        if (richtigFalsch == 1) {
            textView2!!.setTextColor(resources.getColor(R.color.green))
            //textView4.setTextColor(getResources().getColor(R.color.green));
            textView2!!.text = "Richtig!"
            richtigFalsch = 0
        } else {
            textView2!!.setTextColor(resources.getColor(R.color.red))
            //textView4.setTextColor(getResources().getColor(R.color.red));
            textView2!!.text = "Falsch!"
            richtigFalsch = 0
        }

        if (aktuelleFrage == 1) {
            textView4!!.text =
                "Die ersten Pilger kommen seit dem Jahre 1349 alle 7 Jahre nach Aachen, um die Heiligtümer zu bewundern."
        } else if (aktuelleFrage == 2) {
            textView4!!.text = "In Aachen werden die Heiligtümer gelagert und präsentiert."
        } else if (aktuelleFrage == 3) {
            textView4!!.text =
                "Im Marienschrein werden die Heiligtümer zwischen den Heiligtumsfahrten aufbewahrt. Nur alle sieben Jahre wird er geöffnet, um die Heiligtümer zu entnehmen und nach der Heiligtumsfahrt mit einem schlüssellosen Schmuckschloss verschlossen."
        } else if (aktuelleFrage == 4) {
            textView4!!.text =
                "Im Marienschrein ist das Kleid Mariens aus der heiligen Nacht aufbewahrt."
        } else if (aktuelleFrage == 5) {
            textView4!!.text =
                "Im Jahre 1937 waren 1.000.000 Besucher bei der Heiligtumsfahrt. Dies war in der gesamten Geschichte der Heiligtumsfahrt die größte Menge an Besuchern."
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnAntwortEins -> {
                if (frageAuswerten(btnAntwortEins!!.text.toString())) {
                    punkte++
                    richtigFalsch = 1
                }
                /*if (aktuelleFrage >= 4) {
                    Intent intent = new Intent(this, Ende.class);
                    intent.putExtra("Punkte", punkte);
                    startActivity(intent);
                } else {
                    aktuelleFrage++;
                    Intent intent = new Intent(getApplication(),Antwort.class);
                    startActivity(intent);
                    frageLaden();
                }*/
                aktuelleFrage++
                antwortAnzeigen()
            }

            R.id.btnAntwortZwei -> {
                if (frageAuswerten(btnAntwortZwei!!.text.toString())) {
                    punkte++
                    richtigFalsch = 1
                }
                /*if (aktuelleFrage >= 4) {
                    Intent intent = new Intent(this, Ende.class);
                    intent.putExtra("Punkte", punkte);
                    startActivity(intent);
                } else {
                    aktuelleFrage++;
                    Intent intent = new Intent(getApplication(),Antwort.class);
                    startActivity(intent);
                    frageLaden();
                }*/
                aktuelleFrage++
                antwortAnzeigen()
            }

            R.id.btnAntwortDrei -> {
                if (frageAuswerten(btnAntwortDrei!!.text.toString())) {
                    punkte++
                    richtigFalsch = 1
                }
                /*if (aktuelleFrage >= 4) {
                    Intent intent = new Intent(this, Ende.class);
                    intent.putExtra("Punkte", punkte);
                    startActivity(intent);
                } else {
                    aktuelleFrage++;
                    Intent intent = new Intent(getApplication(),Antwort.class);
                    startActivity(intent);
                    frageLaden();
                }*/
                aktuelleFrage++
                antwortAnzeigen()
            }

            R.id.btnAntwortVier -> {
                if (frageAuswerten(btnAntwortVier!!.text.toString())) {
                    punkte++
                    richtigFalsch = 1
                }
                /*if (aktuelleFrage >= 4) {
                    Intent intent = new Intent(this, Ende.class);
                    intent.putExtra("Punkte", punkte);
                    startActivity(intent);
                } else {
                    aktuelleFrage++;
                    Intent intent = new Intent(getApplication(),Antwort.class);
                    startActivity(intent);
                    frageLaden();
                }*/
                aktuelleFrage++
                antwortAnzeigen()
            }
        }
        when (view.id) {
            R.id.btnWeiter -> if (aktuelleFrage >= 4) {
                val intent = Intent(
                    this,
                    Ende::class.java
                )
                intent.putExtra("Punkte", punkte)
                startActivity(intent)
            } else {
                relativeLayout!!.bringToFront()
                frageLaden()
            }
        }
    }

    //bei mehr Fragen: "if (aktuelleFrage >=ANZAHL DER FRAGEN-1)"
    private fun frageAuswerten(btnText: String): Boolean {
        var frage = false
        val fragenC = Fragen()
        val Fragen: ArrayList<*> = fragenC.fragen
        val speicher = Fragen[aktuelleFrage] as Array<String>
        if (speicher[1] == btnText) {
            frage = true
        }
        return frage
    }

    override fun onBackPressed() {
        val ADB = AlertDialog.Builder(this)

        ADB.setTitle("Quiz beenden?")

        //ADB.setIcon();
        ADB.setMessage("Bist du sicher, dass du das Quiz beenden willst?")

        ADB.setCancelable(false)

        ADB.setPositiveButton(
            "Ja"
        ) { dialogInterface, i ->
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
                this@Spiel,
                "Setze das Quiz fort",
                Toast.LENGTH_LONG
            ).show()
        }

        val alertDialog = ADB.create()
        alertDialog.show()
    }
}