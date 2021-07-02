package ba.etf.rma21.projekat.data.models.viewmodel

import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.repositories.KvizRepository

class KvizListViewModel {

    var mojiUpisani = KvizRepository.getMyKvizes()


    fun getFavoriteMovies():List<Kviz>{

        return KvizRepository.getFavoriteMovies().sortedBy { it.datumPocetka }
    }
    fun getUradjeni(): List<Kviz>{
        return KvizRepository.getDone()
    }
    fun getBuduce(): List<Kviz> {
        return KvizRepository.getFuture()
    }
    fun getProsle(): List<Kviz> {
        return KvizRepository.getNotTaken()
    }
    fun getMojeKvizove(): List<Kviz> {
        return KvizRepository.getMyKvizes()
    }


}