package com.osedhelu.creditbanco.ui.Screens.anularPago

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

data class anularPagoData(val card: String, val amount: String)
object anularPagoHelpers : ViewModel() {
    val isLogin: MutableState<anularPagoData> = mutableStateOf(anularPagoData("", ""))

    @Synchronized
    fun reset() {
        isLogin.value = anularPagoData("", "")
    }

}
