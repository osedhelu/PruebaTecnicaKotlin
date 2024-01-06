package com.osedhelu.creditbanco.data.remote


import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface BancoDataSource {
    @Headers("${ApiServiceInterceptor.BACKEND_BANCO}:true")
    @POST("/")
    suspend fun getTokenAuth(@Body body: RequestBody): Any

//    @Headers("${ApiServiceInterceptor.BACKEND_BANCO}:true")
//    @POST(PATH_BANK_LIST_BANK)
//    suspend fun getListBanks(@Body body: IBodyListBank): IRespListBank
//
//    @Headers("${ApiServiceInterceptor.BACKEND_BANCO}:true")
//    @POST(PATH_BANK_SENDPAYMENTB2P)
//    suspend fun emitPayment(@Body body: iPayment): IPaymentResp
//
//    @Headers("${ApiServiceInterceptor.BACKEND_BANCO}:true")
//    @POST(PATH_BANK_QUERYPAYMENTB2P)
//    suspend fun valitPayment(@Body body: iQueryPaymentB2PBody): QueryPaymentB2PResp
}
