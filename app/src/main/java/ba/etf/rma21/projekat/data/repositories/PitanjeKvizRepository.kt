package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.Pitanje

class PitanjeKvizRepository {
    companion object{
        fun getPitanja(nazivKviza:String,nazivPredmeta:String):List<Pitanje>{
            //todo Implementirati metodu da ispravno vraća rezultat
            return listOf(Pitanje("p1","RMA", listOf("a","b","c"),1), Pitanje("p2","BWT", listOf("a","b","c"),2),
            Pitanje("p3","FWT", listOf("a","b","c"),0))
        }
    }
}