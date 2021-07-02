package ba.etf.rma21.projekat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma21.projekat.data.view.KvizListAdapter
import ba.etf.rma21.projekat.data.models.viewmodel.KvizListViewModel
import ba.etf.rma21.projekat.data.repositories.KvizRepository


class UpisPredmet(requireContext: Context) : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var spinnerGrupe: Spinner
    private lateinit var kvizData: RecyclerView
    private lateinit var KvizAdapter: KvizListAdapter
    private var KvizModel = KvizListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.unos_predmeta)

        val spinnerGodine = findViewById<Spinner>(R.id.odabirGodina)
        val spinnerGrupe = findViewById<Spinner>(R.id.odabirGrupa)


        val godine = arrayOf("1","2","3","4","5")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, godine)
        spinnerGodine.adapter = adapter

        /*ArrayAdapter.createFromResource(
                 this,
                 R.array.godine,
                 android.R.layout.simple_spinner_item
         ).also { adapter ->
             // Specify the layout to use when the list of choices appears
             adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
             // Apply the adapter to the spinner
             spinnerGodine.adapter = adapter
         }*/

        spinnerGodine.onItemSelectedListener = this


        val button = findViewById<Button>(R.id.dodajPredmetDugme)

        button.setOnClickListener{
            var imePredmeta = ""
            imePredmeta = spinnerPredmeti.selectedItem.toString()

            val text = spinnerGrupe.selectedItem.toString()
            //var jedan = kvizi.filter { it.nazivPredmeta == imePredmeta }
            var jedan = KvizRepository.getFavoriteMovies()

            KvizRepository.dodaj(jedan[0])
           // println(imePredmeta)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    lateinit var spinnerPredmeti: Spinner

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        spinnerPredmeti = findViewById(R.id.odabirPredmet)
        spinnerGrupe = findViewById(R.id.odabirGrupa)
        val predmetiPrvaGodina = arrayOf("IM")
        val predmetiDrugaGodina = arrayOf("RMA", "DM")
        val grupa2 = arrayOf("Grupa2") //Im, Dm
        val grupa1 = arrayOf("Grupa1")
        val prazno = arrayOf(" ")


        val ad1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, grupa1)
        val ad2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, grupa2)
        if (parent?.selectedItemPosition == 0) {
            val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, predmetiPrvaGodina)
            spinnerPredmeti.adapter = adapter1
            val adapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, grupa2)
            spinnerGrupe.adapter = adapter2




        } else if (parent?.selectedItemPosition == 1) {
            val adapter3 = ArrayAdapter(this, android.R.layout.simple_list_item_1, predmetiDrugaGodina)
            spinnerPredmeti.adapter = adapter3

            spinnerPredmeti.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
                override fun onItemSelected(parent1: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if (parent1?.selectedItemPosition == 0) {
                        spinnerGrupe.adapter = ad1
                    } else {
                        spinnerGrupe.adapter = ad2
                    }
                }

            }

        }else{
            val adapter5 = ArrayAdapter(this, android.R.layout.simple_list_item_1, prazno)
            spinnerPredmeti.adapter = adapter5
            val adapter6 = ArrayAdapter(this, android.R.layout.simple_list_item_1, prazno)
            spinnerGrupe.adapter = adapter6
        }


    }


}




