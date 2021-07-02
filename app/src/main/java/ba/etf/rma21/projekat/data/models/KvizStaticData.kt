package ba.etf.rma21.projekat.data.models

import java.util.*
import kotlin.collections.listOf

fun favoriteMovies(): List<Kviz> {
    return listOf(
        Kviz("Kviz 1",
            "RMA", Date(2021, 4,10),Date(2021,4,10),Date(2021,4,10), 2,"Grupa1",1.5F
        ),
        Kviz("Kviz 1",
            "IM",Date(2021,5,10),Date(2021,5,10),Date(),5,"Grupa2",null
        ),
        Kviz("Kviz 0",
            "RMA",Date(2021,3,10),Date(2021,3,10),null,2,"Grupa1",null
        ),

        Kviz("Kviz 1",
            "DM",Date(2021,3,10),Date(2021,3,10),Date(2021,3,10),5,"Grupa2",2.5F
        ),
        Kviz("Kviz 2",
            "RMA",Date(2021,4,15),Date(2021,4,15),null,2,"Grupa1",null
        )

    )
}
fun mojiKvizovi(): List<Kviz>{
    return listOf(
        Kviz("Kviz 1",
            "IM",Date(2021,5,10),Date(2021,5,10),Date(),5,"Grupa2",null
        )
    )
}
fun uradjeniKvizovi(): List<Kviz> {
    return listOf(
        Kviz("Kviz 1",
            "RMA", Date(2021, 4,10),Date(2021,4,10),Date(2021,4,10), 2,"Grupa1",1.5F
        ),
        Kviz("Kviz 1",
            "DM",Date(2021,3,10),Date(2021,3,10),Date(2021,3,10),5,"Grupa2",2.5F
        )
    )
}
fun buduciKvizovi(): List<Kviz> {
    return listOf(
        Kviz("Kviz 1",
            "IM",Date(2021,5,10),Date(2021,5,10),Date(2021,5,10),5,"Grupa2",null
        )
    )
}
fun prosliKvizovi(): List<Kviz> {
    return listOf(
        Kviz("Kviz 0",
            "RMA",Date(2021,3,10),Date(2021,3,10),Date(2021,3,10),2,"Grupa1",null
        )
    )
}



