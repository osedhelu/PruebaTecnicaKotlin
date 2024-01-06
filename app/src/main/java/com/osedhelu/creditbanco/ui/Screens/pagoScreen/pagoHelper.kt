package com.osedhelu.creditbanco.ui.Screens.pagoScreen


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

data class PagoData(val card: String, val amount: String)

object pagoHelper : ViewModel() {
    val form: MutableState<PagoData> = mutableStateOf(PagoData("", ""))

    @Synchronized
    fun reset() {
        form.value = PagoData("", "")
    }

}
