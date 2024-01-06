/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.osedhelu.creditbanco.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import com.osedhelu.creditbanco.data.local.database.Transaction
import com.osedhelu.creditbanco.data.local.database.TransactionDao

/**
 * Unit tests for [DefaultTransactionRepository].
 */
@OptIn(ExperimentalCoroutinesApi::class) // TODO: Remove when stable
class DefaultTransactionRepositoryTest {

    @Test
    fun transactions_newItemSaved_itemIsReturned() = runTest {
        val repository = DefaultTransactionRepository(FakeTransactionDao())

        repository.add("Repository")

        assertEquals(repository.transactions.first().size, 1)
    }

}

private class FakeTransactionDao : TransactionDao {

    private val data = mutableListOf<Transaction>()

    override fun getTransactions(): Flow<List<Transaction>> = flow {
        emit(data)
    }

    override suspend fun insertTransaction(item: Transaction) {
        data.add(0, item)
    }
}
