package com.osedhelu.creditbanco.data.local.database

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Entity(tableName = "transaction")
data class Transaction(
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}

@Dao
interface TransactionDao {
    @Query("SELECT * FROM `transaction` ORDER BY  uid DESC LIMIT 10")
    fun getMains(): Flow<List<Transaction>>

    @Insert
    suspend fun insertMain(item: Transaction)

}

