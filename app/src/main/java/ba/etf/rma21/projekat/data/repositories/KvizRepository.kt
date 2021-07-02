package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.*
import java.util.*

class KvizRepository {

    companion object {
        var mojiKvizovi = listOf<Kviz>(Kviz("Kviz 1",
            "IM", Date(2021,5,10), Date(2021,5,10),
            Date(),5,"Grupa2",null
        ))

        fun getFavoriteMovies() : List<Kviz> {
            return favoriteMovies();
        }

        // TODO: Implementirati
        init {
            // TODO: Implementirati
        }

        fun getMyKvizes(): List<Kviz> {
            // TODO: Implementirati
            return mojiKvizovi
        }

        fun dodaj(k : Kviz){
            var a = mojiKvizovi.toMutableList()
            a.add(k)
            mojiKvizovi = a

        }

        fun getAll(): List<Kviz> {
            // TODO: Implementirati
            return favoriteMovies()
        }

        fun getDone(): List<Kviz> {
            // TODO: Implementirati
            return uradjeniKvizovi()
        }

        fun getFuture(): List<Kviz> {
            // TODO: Implementirati
            return buduciKvizovi()
        }

        fun getNotTaken(): List<Kviz> {
            // TODO: Implementirati
            return prosliKvizovi()
        }
        // TODO: Implementirati i ostale potrebne metode
    }
}