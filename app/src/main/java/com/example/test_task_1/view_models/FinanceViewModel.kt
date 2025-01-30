package com.example.test_task_1.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_task_1.db.Dao
import com.example.test_task_1.db.Goal
import com.example.test_task_1.db.Transaction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import kotlin.math.ceil

@HiltViewModel
class FinanceViewModel @Inject constructor(
    private val dao: Dao
): ViewModel() {
    private var job: Job? = null

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

    private val _goalDeadline = MutableStateFlow("")
    val goalDeadline: StateFlow<String> get() = _goalDeadline

    private val _goalMessage = MutableStateFlow<String?>(null)
    val goalMessage: StateFlow<String?> get() = _goalMessage

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            loadTransactions()
            calculateBalance()
            loadGoal()
        }
    }

    private suspend fun loadTransactions() {
        viewModelScope.launch {
            dao.getAllTransactions().collect {
                _transactions.value = it
            }
            Log.d("FinanceViewModel", "Transactions loaded: ${transactions.value.size}")
        }
    }

    private suspend fun loadGoal() {
        viewModelScope.launch {
            dao.getGoal().collect {
                _goal.value = it ?: return@collect
                calculateGoalDeadline(it.amount)
            }
        }
    }

    private fun calculateBalance() {
        job?.cancel()
        job = viewModelScope.launch {
            launch {
                dao.getTotalIncome().collect {
                    _totalIncome.value = it ?: 0.0
                    Log.d("FinanceViewModel", "Income: $it")
                    updateSavings()
                }
            }
            launch {
                dao.getTotalExpense().collect {
                    _totalExpense.value = it ?: 0.0
                    Log.d("FinanceViewModel", "Expense: $it")
                    updateSavings()
                }
            }
        }
    }

    private fun updateSavings() {
        _savings.value = _totalIncome.value - _totalExpense.value
    }

    fun addTransaction(transaction: Transaction) {
        viewModelScope.launch {
            dao.insertTransaction(transaction)
            loadTransactions()
            calculateBalance()
            calculateGoalDeadline(_goal.value?.amount ?: 0.0)
            updateGoal(
                _goal.value?.copy(
                    deadline = _goalDeadline.value
                ) ?: return@launch
            )
        }
    }

    fun deleteTransaction(transaction: Transaction) {
        viewModelScope.launch {
            dao.deleteTransaction(transaction)
            loadTransactions()
            calculateBalance()
            calculateGoalDeadline(_goal.value?.amount ?: 0.0)
            updateGoal(
                _goal.value?.copy(
                    deadline = _goalDeadline.value
                ) ?: return@launch
            )
        }
    }

    fun calculateGoalDeadline(goalAmount: Double) {
        viewModelScope.launch {
            updateSavings()
            val currentSavings = _savings.value

            if (currentSavings <= 0) {
                _goalDeadline.value = "Нет"
                return@launch
            } else {
                val monthsNeeded = ceil(goalAmount / currentSavings).toInt()

                _goalDeadline.value = monthsNeeded.toString()
            }
        }
    }

    fun setGoal(goal: Goal) {
        viewModelScope.launch {
            if (_goal.value != null) {
                _goalMessage.value = "Цель уже установлена"
            } else {
                dao.insertGoal(goal)
                _goal.value = goal
            }
        }
    }

    fun updateGoal(newGoal: Goal) {
        viewModelScope.launch {
            dao.updateGoal(newGoal)
            _goal.value = newGoal
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

    fun clearGoalMessage() {
        _goalMessage.value = null
    }
}





