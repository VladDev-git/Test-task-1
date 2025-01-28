package com.example.test_task_1.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    // Transactions
    @Insert
    suspend fun insertTransaction(transaction: Transaction)

    @Query("SELECT * FROM transactions WHERE type = :type ORDER BY id DESC")
    fun getTransactionsByType(type: String): Flow<List<Transaction>>

    @Query("SELECT SUM(amount) FROM transactions WHERE type = 'income'")
    suspend fun getTotalIncome(): Double?

    @Query("SELECT SUM(amount) FROM transactions WHERE type = 'expense'")
    suspend fun getTotalExpense(): Double?

    @Query("SELECT * FROM transactions")
    fun getAllTransactions(): Flow<List<Transaction>>

    // Goals
    @Insert
    suspend fun insertGoal(goal: Goal)

    @Query("SELECT * FROM goals ORDER BY deadline ASC")
    fun getGoal(): Flow<Goal>

    @Delete
    suspend fun deleteGoal(goal: Goal)
}