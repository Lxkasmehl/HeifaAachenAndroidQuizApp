package com.example.heifaaachenquiz

class Fragen {
    /*
       }, {
           question: 'Wie viel Einwohner hatte Aachen im 15. Jahrhundert ungefähr?',
           solution: '10.000',
           falses: ['245.000',
               '1.000',
               '131.000'],
           explanation: 'Im 15. Jahrhundert hatte Aachen ungefähr 10.000 Einwohner. Trotzdem kamen täglich rund 100.000 Pilger in die Stadt.'
       }, {
           question: 'Wie wollten die Menschen im Mittelalter die Gnade und die Kraft der Heiligtümer einfangen?',
           solution: 'mit Spiegeln',
           falses: ['mit Kächern',
               'mit Fischernetzen',
               'gar nicht'],
           explanation: 'Die Menschen versuchten auf den Hausdächern stehend mit kleinen Spiegeln die Gnade und die Kraft der Heilitümer einzufangen. So wollten sie mit den so genannten Aachen-Spiegeln die Gande und Kraft der Heiligtümer mit nach Hause nehmen.'
       }, {
           question: 'Wann wurde die Pfalzkapelle bzw. der Aachener Dom eingeweiht?',
           solution: '799',
           falses: ['1553',
               '328',
               '1004'],
           explanation: 'Die Pfalzkapelle wurde im Jahr 799 in Aachen eingeweiht.'
       }
        */
    var fragen: ArrayList<Array<String?>> = ArrayList(20)

    init {
        listeFuellen()
    }

    private fun listeFuellen() {
        val frage1 = arrayOfNulls<String>(5)
        frage1[0] = "In welchen zeitlichen Abständen findet die Heiligtumsfahrt statt?"
        frage1[1] = "alle 7 Jahre"
        frage1[2] = "alle 4 Jahre"
        frage1[3] = "alle 5 Jahre"
        frage1[4] = "alle 10 Jahre"

        val frage2 = arrayOfNulls<String>(5)
        frage2[0] = "Wo findet die Heiligtumsfahrt statt?"
        frage2[1] = "Aachen"
        frage2[2] = "Karlsruhe"
        frage2[3] = "Köln"
        frage2[4] = "Düsseldorf"

        val frage3 = arrayOfNulls<String>(5)
        frage3[0] = "Wo werden die Heiligtümer aufbewahrt?"
        frage3[1] = "Marienschrein"
        frage3[2] = "Karlsschrein"
        frage3[3] = "Jesusschrein"
        frage3[4] = "Dreikönigsschrein"

        val frage4 = arrayOfNulls<String>(5)
        frage4[0] = "Welches Kleidungsstück Marias liegt als Heiligtum in Aachen?"
        frage4[1] = "Ihr Kleid"
        frage4[2] = "Ihr Kopftuch"
        frage4[3] = "Ihre Hose"
        frage4[4] = "Ihr Shirt"

        val frage5 = arrayOfNulls<String>(5)
        frage5[0] = "Was war die höchste Besucheranzahl bei der Heiligtumsfahrt?"
        frage5[1] = "1.000.000"
        frage5[2] = "100.000"
        frage5[3] = "5.000.000"
        frage5[4] = "876"

        fragen.add(0, frage1)
        fragen.add(1, frage2)
        fragen.add(2, frage3)
        fragen.add(3, frage4)
        fragen.add(4, frage5)
        //bei neuer Frage frage hier oberhalb adden
    }
}