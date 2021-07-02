package ba.etf.rma21.projekat.data.models.view

import android.os.Bundle
import android.view.*
import android.widget.ListView
import androidx.core.view.get
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Pitanje
import com.google.android.material.navigation.NavigationView


class FragmentPokusaj(val listView: List<Pitanje>) : Fragment() {
    private lateinit var navigationView: NavigationView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_pokusaj, container, false)

       // getWindow().setNavigationBarColor(getResources().getColor(R.color.your_awesome_color))

        navigationView= view.findViewById(R.id.navigacijaPitanja)
       // navigationView.setNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        for (i in listView.indices) {

           // navigationView.menu.clear()
            navigationView.menu.add(R.id.grupa, i, i, (i+1).toString())

            navigationView.setNavigationItemSelectedListener { item ->
                val someFragment: Fragment = FragmentPitanje(listView[item.order])
                openFragment(someFragment)

                true
            }
        }

        return view;
    }

    private fun openFragment(fragment: Fragment){
        val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
        transaction.replace(
                R.id.framePitanje,
                fragment
        )
        transaction.addToBackStack(null)
        transaction.commit()

    }
    companion object {
        fun newInstance(listView: List<Pitanje>): FragmentPokusaj = FragmentPokusaj(listView)
    }
}