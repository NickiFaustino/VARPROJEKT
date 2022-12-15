package com.example.varprojekt.models

data class QR(
    var id: String?,
    var title: String?,
    val description: String?,
    val time: String?,
)

fun getQR(): List<QR>{
    return listOf(
        QR(
            id="1",
            title = "Matthias",
            description = "Ottakringer Straße",
            time = "10",
        ),
        QR(
            id="2",
            title = "Mario",
            description = "Julius-Ficker Straße",
            time = "9"
        ),
        QR(
            id="3",
            title = "Eler",
            description = "Perfektastraße",
            time = "8"
        ),
        QR(
            id="4",
            title = "Andreas",
            description = "Meister",
            time = "7"
        ),
        QR(
            id="5",
            title = "Nicki",
            description = "Leopoldsdorf",
            time = "6"
        )
    )
}
fun createQR(): QR{
    return QR(
        id ="",
        title = "",
        description = "",
        time = ""
    )
}
