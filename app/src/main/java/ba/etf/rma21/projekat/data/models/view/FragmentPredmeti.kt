package ba.etf.rma21.projekat.data.models.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ba.etf.rma21.projekat.FragmentPoruka
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.viewmodel.KvizListViewModel
import ba.etf.rma21.projekat.data.repositories.GrupaRepository
import ba.etf.rma21.projekat.data.repositories.KvizRepository
import ba.etf.rma21.projekat.data.view.KvizListAdapter


class FragmentPredmeti : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var favoriteMoviesAdapter: KvizListAdapter
    private var movieListViewModel = KvizListViewModel()
    lateinit var spinnerPredmeti: Spinner
    lateinit var spinnerGodine: Spinner


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_upis, container, false)

        spinnerGodine = view.findViewById<Spinner>(R.id.odabirGodina)
        spinnerGrupe = view.findViewById<Spinner>(R.id.odabirGrupa)


        val godine = arrayOf("1","2","3","4","5")

        val adapter = activity?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, godine) }
        spinnerGodine.adapter = adapter

        spinnerGodine.onItemSelectedListener = this
        val button = view.findViewById<Button>(R.id.dodajPredmetDugme)
        spinnerPredmeti = view.findViewById(R.id.odabirPredmet)

        button.setOnClickListener{


            val text = spinnerGrupe.selectedItem.toString()
            //var jedan = kvizi.filter { it.nazivPredmeta == imePredmeta }
            var jedan = KvizRepository.getFavoriteMovies()
            var jedanGrupa = GrupaRepository.getGrupe()

            KvizRepository.dodaj(jedan[0])
            GrupaRepository.dodajGrupu(jedanGrupa[0])



            val nazivGrupe = spinnerGrupe.selectedItem.toString()
           // println(imeGrupe)
            val nazivPredmeta = spinnerPredmeti.selectedItem.toString()
            //(nazivGrupe)

            val bundle = Bundle()
            bundle.putString("grupa", nazivGrupe)
            bundle.putString("predmet", nazivPredmeta)
            val porukaFragment : FragmentPoruka = FragmentPoruka.newInstance(nazivGrupe,nazivPredmeta)

            porukaFragment.arguments = bundle

            val someFragment: Fragment = FragmentPoruka.newInstance(nazivGrupe,nazivPredmeta)
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            transaction.replace(
                    R.id.container,
                    someFragment
            )
            transaction.addToBackStack(null)
            transaction.commit()
        }


        return view;
    }


    companion object {
        fun newInstance(): FragmentPredmeti = FragmentPredmeti()

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    lateinit var spinnerGrupe: Spinner
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val predmetiPrvaGodina = arrayOf("IM")
        val predmetiDrugaGodina = arrayOf("RMA", "DM")
        val grupa2 = arrayOf("Grupa2") //Im, Dm
        val grupa1 = arrayOf("Grupa1")
        val prazno = arrayOf(" ")


        val ad1 = activity?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, grupa1) }
        val ad2 = activity?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, grupa2) }

        if (parent?.selectedItemPosition == 0) {
            var adapter1 = activity?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, predmetiPrvaGodina) }
            spinnerPredmeti.adapter = adapter1
            var adapter2 = activity?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, grupa2) }
            spinnerGrupe.adapter = adapter2

        } else if (parent?.selectedItemPosition == 1) {
            val adapter3 = activity?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, predmetiDrugaGodina) }
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
            val adapter5 =
                activity?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, prazno) }
            spinnerPredmeti.adapter = adapter5
            val adapter6 =
                activity?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, prazno) }
            spinnerGrupe.adapter = adapter6
        }


    }


}