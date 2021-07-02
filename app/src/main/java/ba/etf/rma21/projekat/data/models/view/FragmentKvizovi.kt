package ba.etf.rma21.projekat.data.models.view

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma21.projekat.FragmentPoruka
import ba.etf.rma21.projekat.MainActivity
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.UpisPredmet
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.mojiKvizovi
import ba.etf.rma21.projekat.data.models.viewmodel.KvizListViewModel
import ba.etf.rma21.projekat.data.repositories.PitanjeKvizRepository
import ba.etf.rma21.projekat.data.view.KvizListAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView


class FragmentKvizovi : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var favoriteMovies: RecyclerView
    private lateinit var favoriteMoviesAdapter: KvizListAdapter
    private var movieListViewModel = KvizListViewModel()
    private lateinit var spinner: Spinner
   //  lateinit var kviz: Kviz


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =  inflater.inflate(R.layout.fragment_kvizovi, container, false)
        favoriteMovies = view.findViewById(R.id.listaKvizova)
        favoriteMovies.layoutManager = GridLayoutManager(activity,3, GridLayoutManager.HORIZONTAL,false)

        this.spinner= view.findViewById(R.id.filterKvizova);

        activity?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.city_list,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                spinner.adapter = adapter
            }
        }
        spinner.onItemSelectedListener = this


        favoriteMoviesAdapter = KvizListAdapter(arrayListOf()) { movie,view1,view2 -> showMovieDetails(movie,view1,view2) }
        favoriteMovies.adapter = favoriteMoviesAdapter
        favoriteMoviesAdapter.updateMovies(movieListViewModel.getFavoriteMovies())



        return view;

    }

    private fun showMovieDetails(movie: Kviz, view1: View,view2:View) {
        //val searchFragment = FragmentPredmeti.newInstance()
        openFragment(movie)
        val nav = activity?.findViewById<BottomNavigationView>(R.id.bottomNav)
        if(nav != null){
            nav.menu.findItem(R.id.kvizovi).isVisible = false
            nav.menu.findItem(R.id.predmeti).isVisible = false;
            nav.menu.findItem(R.id.predajKviz).isVisible = true;
            nav.menu.findItem(R.id.zaustaviKviz).isVisible = true;
        }
    }
    private fun openFragment(kviz: Kviz) {
        val someFragment: Fragment = FragmentPokusaj.newInstance(PitanjeKvizRepository.getPitanja(kviz.naziv,kviz.nazivPredmeta))
        val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
        transaction.replace(
                R.id.container,
                someFragment
        )
        transaction.addToBackStack(null)
        transaction.commit()

    }
    companion object {
        fun newInstance(): FragmentKvizovi = FragmentKvizovi()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(parent?.selectedItemPosition == 0){
            favoriteMoviesAdapter.updateMovies(movieListViewModel.getMojeKvizove())
        }else if(parent?.selectedItemPosition == 1){
            favoriteMoviesAdapter.updateMovies(movieListViewModel.getFavoriteMovies())
        }else if(parent?.selectedItemPosition == 2){
            favoriteMoviesAdapter.updateMovies(movieListViewModel.getUradjeni())
        }else if(parent?.selectedItemPosition == 3){
            favoriteMoviesAdapter.updateMovies(movieListViewModel.getBuduce())
        }else if(parent?.selectedItemPosition == 4){
            favoriteMoviesAdapter.updateMovies(movieListViewModel.getProsle())
        }else{
            favoriteMoviesAdapter.updateMovies(emptyList())
        }
    }


}

