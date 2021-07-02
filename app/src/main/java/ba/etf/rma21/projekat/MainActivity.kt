package ba.etf.rma21.projekat

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.view.FragmentKvizovi
import ba.etf.rma21.projekat.data.models.view.FragmentPokusaj
import ba.etf.rma21.projekat.data.models.view.FragmentPredmeti
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(){
    private lateinit var bottomNavigation: BottomNavigationView
    private val filter = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
    //Listener za click
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
         when (item.itemId) {
            R.id.kvizovi -> {
                val favoritesFragment = FragmentKvizovi.newInstance()
                openFragment(favoritesFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.predmeti -> {
                val upisFragment  = FragmentPredmeti.newInstance()
                openFragment(upisFragment)
                return@OnNavigationItemSelectedListener true
            }
             R.id.zaustaviKviz -> {
                 val favoritesFragment = FragmentKvizovi.newInstance()
                 openFragment(favoritesFragment)
                 return@OnNavigationItemSelectedListener true
             }

        }
        /*val pokusajFragment  = FragmentPokusaj().newInstance()
        openFragment(pokusajFragment)*/

        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation= findViewById(R.id.bottomNav)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        //Defaultni fragment
        bottomNavigation.selectedItemId= R.id.kvizovi

        val favoritesFragment = FragmentKvizovi.newInstance()
        openFragment(favoritesFragment)

        val nav = this?.findViewById<BottomNavigationView>(R.id.bottomNav)
        if(nav != null){
            nav.menu.findItem(R.id.kvizovi).isVisible = true
            nav.menu.findItem(R.id.predmeti).isVisible = true;
            nav.menu.findItem(R.id.predajKviz).isVisible = false;
            nav.menu.findItem(R.id.zaustaviKviz).isVisible = false;
        }
    }
    //Funkcija za izmjenu fragmenta
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun handleSendText(intent: Intent) {
        intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
            bottomNavigation.selectedItemId= R.id.bottomNav
            val searchFragment = FragmentPredmeti.newInstance()
            openFragment(searchFragment)
        }
    }

   /* override fun onItemClick(item: Kviz, position: View) {
       // Toast.makeText(this, item.name , Toast.LENGTH_SHORT).show()
        val searchFragment = FragmentPredmeti.newInstance()
        openFragment(searchFragment)
    }*/

}


