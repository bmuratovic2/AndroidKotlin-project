package ba.etf.rma21.projekat.data.models

import java.util.*


fun Grupa(): List<Grupa> {
    return listOf(
            Grupa("Grupa1",
                    "RMA")
            ,
            Grupa("Grupa2",
            "DM"),
            Grupa("Grupa2",
                    "IM")

    )
}
var listaUpisanihGrupa = mutableListOf(Grupa("bp1", "BP"))

fun funkcija(): List<Grupa> {
    return listaUpisanihGrupa
}