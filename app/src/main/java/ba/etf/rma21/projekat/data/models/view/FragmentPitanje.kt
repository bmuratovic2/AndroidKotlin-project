package ba.etf.rma21.projekat.data.models.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Pitanje
import com.google.android.material.navigation.NavigationView


class FragmentPitanje(var pitanje: Pitanje) : Fragment() {
    private lateinit var pitanja: ListView
    private lateinit var navigationView: NavigationView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_pitanje, container, false)
        //val nav = activity?.findViewById<NavigationView>(R.id.navigacijaPitanja)
        val lista1 = arrayOf("DA","NE","MOZDA");
        val adapter: ArrayAdapter<String> = ArrayAdapter(view.context, android.R.layout.simple_spinner_item, lista1)

        val tekst = view.findViewById<TextView>(R.id.tekstPitanja)
        tekst.text = pitanje.tekst

        pitanja = view.findViewById<ListView>(R.id.odgovoriLista)
        pitanja.adapter = adapter



        /*toolbar.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.pitanje1 -> {
                    val lista1 = arrayOf("DA","NE");
                    val adapter: ArrayAdapter<String> = ArrayAdapter(view.context, android.R.layout.simple_spinner_item, lista1)

                    pitanja = view.findViewById<ListView>(R.id.odgovoriLista)
                    pitanja.adapter = adapter
                }
                R.id.pitanje2 -> {
                    val lista = arrayOf("Mozda","Ma NE");
                    val adapter1: ArrayAdapter<String> = ArrayAdapter(view.context, android.R.layout.simple_spinner_item, lista)

                    pitanja = view.findViewById<ListView>(R.id.odgovoriLista)
                    pitanja.adapter = adapter1
                }
                // your reset case
            }
            true
        }*/


        return view;
    }



    companion object {
        fun newInstance(pitanje: Pitanje): FragmentPitanje = FragmentPitanje(pitanje)
    }


}


