package com.osedhelu.creditbanco.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseDto<T>(
    @SerializedName("ok") var ok: Boolean = false,
    @SerializedName("data") var data: T
)