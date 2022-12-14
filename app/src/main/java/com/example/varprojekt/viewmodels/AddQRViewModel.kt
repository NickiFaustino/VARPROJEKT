package com.example.varprojekt.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.varprojekt.models.QR

class AddQRViewModel : ViewModel(){

    private val _addedQR = mutableStateListOf<QR>()
    val addedQR: List<QR>
        get() = _addedQR

    fun addQR(qr: QR) {
        if (!exists(qr = qr)) {
            _addedQR.add(qr)
        }
    }

    fun removeRecipe(qr: QR){
        _addedQR.remove(qr)
    }

    private fun exists(qr: QR) : Boolean {
        return _addedQR.any {r -> r.id == qr.id}
    }

    fun removeAllQR() {
        if(addedQR.lastIndex > 0) {
            _addedQR.clear()
        }
    }

    fun isadded(qr: QR): Boolean {
        return exists(qr)
    }
}
