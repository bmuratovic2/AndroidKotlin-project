package ba.etf.rma21.projekat.data.models.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.Pitanje

class PitanjeListAdapter(
        private val context: Context,
        private val arrayList: java.util.ArrayList<Pitanje>
) : BaseAdapter() {
    private lateinit var tekst: TextView
    private lateinit var lista: ListView
    override fun getCount(): Int {
        return arrayList.size
    }
    override fun getItem(position: Int): Any {
        return position
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.fragment_pitanje, parent, false)
        tekst = convertView.findViewById(R.id.tekstPitanja)
        lista = convertView.findViewById(R.id.navigacijaPitanja)

        tekst.text = " " + arrayList[position].tekst

        return convertView
    }
}