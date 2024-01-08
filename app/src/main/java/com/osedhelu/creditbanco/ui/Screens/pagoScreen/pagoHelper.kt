package com.osedhelu.creditbanco.ui.Screens.pagoScreen


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.osedhelu.creditbanco.data.remote.dto.PaymentRespDto
import com.osedhelu.creditbanco.data.remote.dto.ResponseDto

data class PagoData(val card: String, val amount: String)
data class PagoDataResponse(val card: String, val amount: String)

object pagoHelper : ViewModel() {
    val form: MutableState<PagoData> = mutableStateOf(PagoData("", ""))
    val formResp: MutableState<ResponseDto<PaymentRespDto>> =
        mutableStateOf(ResponseDto(false, PaymentRespDto()))
    val numTab: MutableState<Int> = mutableStateOf(0)

    @Synchronized
    fun reset() {
        form.value = PagoData("", "")
        numTab.value = 0
    }

    @Synchronized
    fun nextTabs() {
        numTab.value = numTab.value + 1
    }

    @Synchronized
    fun lastTabs() {
        numTab.value = numTab.value - 1
    }
}
