package com.example.test_task_1.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_task_1.db.Dao
import com.example.test_task_1.db.Goal
import com.example.test_task_1.db.Transaction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FinanceViewModel @Inject constructor(
    private val dao: Dao
): ViewModel() {
    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> get() = _transactions

    private val _goal = MutableStateFlow<Goal?>(null)
    val goal: StateFlow<Goal?> get() = _goal

    private val _totalIncome = MutableStateFlow(0.0)
    val totalIncome: StateFlow<Double> get() = _totalIncome

    private val _totalExpense = MutableStateFlow(0.0)
    val totalExpense: StateFlow<Double> get() = _totalExpense

    private val _savings = MutableStateFlow(0.0)
    val savings: StateFlow<Double> get() = _savings

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            loadTransactions()
            loadGoal()
            calculateBalance()
        }
    }

    private suspend fun loadTransactions() {
        _transactions.value = dao.getAllTransactions().firstOrNull() ?: emptyList()
    }

    private suspend fun loadGoal() {
        dao.getGoal().collect {
            _goal.value = it
        }
    }

    private suspend fun calculateBalance() {
        _totalIncome.value = dao.getTotalIncome() ?: 0.0
        _totalExpense.value = dao.getTotalExpense() ?: 0.0
        _savings.value = _totalIncome.value - _totalExpense.value
    }

    fun addTransaction(transaction: Transaction) {
        viewModelScope.launch {
            dao.insertTransaction(transaction)
            loadTransactions()
            calculateBalance()
        }
    }

    fun setGoal(goal: Goal) {
        viewModelScope.launch {
            dao.insertGoal(goal)
            _goal.value = goal
        }
    }

    fun deleteGoal() {
        viewModelScope.launch {
            _goal.value?.let {
                dao.deleteGoal(it)
                _goal.value = null
            }
        }
    }
}





