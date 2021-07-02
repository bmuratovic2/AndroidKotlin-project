package ba.etf.rma21.projekat.data.models

import java.util.*

fun Grupa1(): List<Kviz> {
    return listOf(
        Kviz("Kviz 1",
            "RMA", Date(2021, 4,10), Date(2021,4,10), Date(2021,4,10), 2,"Grupa1",1.5F
        ),
        Kviz("Kviz 0",
            "RMA", Date(2021,3,10), Date(2021,3,10),null,2,"Grupa1",null
        ),
        Kviz("Kviz 2",
            "RMA", Date(2021,4,15), Date(2021,4,15),null,2,"Grupa1",null
        )

    )
}