package ba.etf.rma21.projekat.data.models.viewmodel

import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.repositories.KvizRepository
import ba.etf.rma21.projekat.data.repositories.PredmetRepository

class PredmetiListViewModel {
    fun list(): List<Kviz> {
        return PredmetRepository.getAll()
    }
}