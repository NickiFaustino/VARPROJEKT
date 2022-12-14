package com.example.varprojekt.models

data class QR(
    val id: String,
    val title: String?,
    val description: String?,
)

fun getQR(): List<QR>{
    return listOf(
        QR(
            id="1",
            title = "Matthias",
            description = "Ottakringer Straße"
        ),
        QR(
            id="2",
            title = "Mario",
            description = "Julius-Ficker Straße"
        ),
        QR(
            id="3",
            title = "Eler",
            description = "Perfektastraße"
        ),
        QR(
            id="4",
            title = "Andreas",
            description = "Meister"
        ),
        QR(
            id="5",
            title = "Nicki",
            description = "Leopoldsdorf"
        )
    )
}
