package com.osedhelu.creditbanco.ui.components.Loading


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.osedhelu.creditbanco.R

enum class IconType(val rgb: Int) {
    SUCCESS(R.raw.success), DANGER(R.raw.error), MAIN(R.raw.logo_animate),
}


object LoadingHelper : ViewModel() {
    val isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading01: MutableState<Boolean> = mutableStateOf(false)
    val isLoading02: MutableState<Boolean> = mutableStateOf(false)
    val isLoadingMessage: MutableState<String> = mutableStateOf("")
    val iconSuccessError: MutableState<IconType> = mutableStateOf(IconType.MAIN)

    @Synchronized
    fun ResetParams() {
        isLoading.value = false
        isLoading01.value = false
        isLoading02.value = false
        isLoadingMessage.value = ""
        iconSuccessError.value = IconType.MAIN
    }

    @Synchronized
    fun showLoading(text: String) {
        isLoading.value = true
        isLoading01.value = true
        isLoading02.value = true
        isLoadingMessage.value = text
        iconSuccessError.value = IconType.MAIN
    }

    @Synchronized
    fun showLoadingSuccess(text: String) {
        isLoadingMessage.value = text
        iconSuccessError.value = IconType.SUCCESS
    }

    @Synchronized
    fun showLoadingError(text: String) {
        isLoadingMessage.value = text
        iconSuccessError.value = IconType.DANGER
    }
}
