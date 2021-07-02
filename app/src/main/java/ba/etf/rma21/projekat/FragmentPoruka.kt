package ba.etf.rma21.projekat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ba.etf.rma21.projekat.data.models.view.FragmentPredmeti

class FragmentPoruka(nazivGrupe: String,imePredmeta: String) : Fragment(){

    private lateinit var predmeti: UpisPredmet

    private lateinit var textView: TextView
    val grupaNaziv = nazivGrupe
    val nazivPredmeta= imePredmeta

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_poruka, container, false)

        val tvporuka : TextView = view.findViewById(R.id.tvPoruka)
        val bundle1 : Bundle? = this.arguments
       // val nazivPredmeta = bundle1?.getString("predmet")
        val text : String = "Uspješno ste upisani u grupu ${grupaNaziv} predmeta ${nazivPredmeta}!"
        tvporuka.setText(text)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                /*val someFragment: Fragment = FragmentPredmeti.newInstance()
                val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
                transaction.replace(
                        R.id.container,
                        someFragment
                )
                transaction.addToBackStack(null)
                transaction.commit()*/
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            }
        })


    return view
    }

    companion object {
        fun newInstance(nazivGrupe : String, nazivPredmeta: String) : FragmentPoruka = FragmentPoruka(nazivGrupe,nazivPredmeta)
    }
}