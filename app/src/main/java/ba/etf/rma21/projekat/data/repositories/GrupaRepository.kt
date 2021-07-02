package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.Predmet
import java.util.*


class GrupaRepository {
    companion object {
        var mojiKvizovi = listOf<Grupa>(Grupa("Kviz 1",
                "IM"))

        init {
            // TODO: Implementirati
        }
        fun getGrupe(): List<Grupa> {
            // TODO: Implementirati
            return Grupa()
        }

        fun dodajGrupu(k : Grupa){
            var a = GrupaRepository.mojiKvizovi.toMutableList()
            a.add(k)
            GrupaRepository.mojiKvizovi = a
        }


    }
}