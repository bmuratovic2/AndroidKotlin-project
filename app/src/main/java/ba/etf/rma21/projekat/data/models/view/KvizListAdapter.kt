package ba.etf.rma21.projekat.data.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.favoriteMovies
import java.util.*


class KvizListAdapter(
    private var kvizovi: List<Kviz>,
    private val onItemClicked: (movie:Kviz,view1:View,view2:View) -> Unit
) : RecyclerView.Adapter<KvizListAdapter.KvizViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KvizViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_kviz, parent, false)
        return KvizViewHolder(view)
    }
    override fun getItemCount(): Int = kvizovi.size
    override fun onBindViewHolder(holder: KvizViewHolder, position: Int) {
        holder.movieTitle.text = kvizovi[position].nazivPredmeta
        holder.textView2.text = kvizovi[position].naziv
        holder.idTrajanje.text = kvizovi[position].trajanje.toString()
        holder.idBodovi.text = kvizovi[position].osvojeniBodovi.toString()

        val dateString = Datum(kvizovi[position].datumPocetka.date,kvizovi[position].datumPocetka.month,kvizovi[position].datumPocetka.year)
        holder.datumId.text = dateString

        val bod = kvizovi[position].osvojeniBodovi;
        val imeKviza = kvizovi[position].naziv
        val pocetak = kvizovi[position].datumPocetka
        val kraj = kvizovi[position].datumKraj
        val vrijemeRada = kvizovi[position].datumRada
        val trenutno = Date(2021, 4,12)

        if(bod==null) holder.idBodovi.text = " "

        val ime = kvizovi[position].nazivPredmeta

        if (pocetak.before(trenutno) && vrijemeRada != null && bod != null) {
            holder.krugici.setImageResource(R.drawable.plava)
        }
        if(pocetak.after(trenutno) && vrijemeRada != null && bod==null){
            holder.krugici.setImageResource(R.drawable.zuta)
        }
        if(pocetak.after(trenutno) && vrijemeRada == null && bod==null){
            holder.krugici.setImageResource(R.drawable.zelena)
        }
        if(pocetak.before(trenutno) && vrijemeRada == null && bod==null ){
            holder.krugici.setImageResource(R.drawable.crvena)
        }

        holder.itemView.setOnClickListener{ onItemClicked(kvizovi[position],holder.krugici,holder.movieTitle) }

    }
    fun updateMovies(kvizovi: List<Kviz>) {
        this.kvizovi = kvizovi
        notifyDataSetChanged()
    }
    inner class KvizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val krugici: ImageView = itemView.findViewById(R.id.krugici)
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val textView2: TextView = itemView.findViewById(R.id.textView2)
        val idTrajanje: TextView = itemView.findViewById(R.id.idTrajanje)
        val idBodovi: TextView = itemView.findViewById(R.id.idBodovi)
        val datumId: TextView = itemView.findViewById(R.id.datumId)
    }

    fun Datum(day: Int , month : Int, year : Int ) : String {

        var datum1 = " "

        if(day < 10 ){
            datum1 = datum1.plus("0")
        }
        var datum2 = datum1.plus(day).plus(".")

        if(month < 10){
            datum2 = datum2.plus("0")
        }
        var konacniDatum = datum2.plus(month).plus(".")
        var konacniDatum2 = konacniDatum.plus(year).plus(".")

        return konacniDatum2
    }


}



