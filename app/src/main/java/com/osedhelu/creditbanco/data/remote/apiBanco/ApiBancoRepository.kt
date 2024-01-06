package com.osedhelu.creditbanco.data.remote.apiBanco

import com.osedhelu.creditbanco.data.remote.BancoDataSource
import javax.inject.Inject


interface ApiBancoRepository {
    suspend fun getTokenAuth(): String
}

class ApiBancoRepositoryImp @Inject constructor(
    private val MiApiDataSource: BancoDataSource,
) : ApiBancoRepository {
    override suspend fun getTokenAuth(): String {
        return "hola mundo"
    }

}
