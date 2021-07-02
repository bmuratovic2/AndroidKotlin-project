package ba.etf.rma21.projekat.data.models

fun predmeti(): List<Predmet> {
    return listOf(
        Predmet("RMA", 2),
        Predmet("DM", 2),
        Predmet("IM",1)
    )
}
fun upisani(): List<Predmet> {
    return listOf(
        Predmet("RMA", 2)
    )
}