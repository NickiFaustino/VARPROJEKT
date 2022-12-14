package com.example.varprojekt.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.varprojekt.models.QR
import com.example.varprojekt.models.getQR

@Composable
fun QRRow(
    qr: QR = getQR()[0],
    onItemClick: (String) -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                qr.id?.let { onItemClick(it) }
            },
        shape = RoundedCornerShape(4.dp),
        elevation = 6.dp
    ) {
        Column(modifier = Modifier.padding(6.dp)) {
            Row(
                modifier = Modifier
                    .padding(6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .padding(6.dp)
                        .width(250.dp)
                ) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(qr.id)
                    qr.title?.let { Text(it) }
                    qr.description?.let { Text(it) }
                }
                content()
            }
        }
    }

}
@Composable
fun RemoveIcon(
    qr: QR = getQR()[0],
    onRemoveClick: (QR) -> Unit = {}
) {
    IconButton(modifier = Modifier.width(80.dp),
        onClick = { onRemoveClick(qr) }) {
        Icon(
            tint = MaterialTheme.colors.secondary,
            imageVector = Icons.Default.Delete,
            contentDescription = "remove from list"
        )
    }
}