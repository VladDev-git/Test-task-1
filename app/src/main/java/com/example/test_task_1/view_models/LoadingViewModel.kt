package com.example.test_task_1.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoadingViewModel @Inject constructor(

) : ViewModel() {
    private val _progressValue = mutableStateOf(0f)
    val progressValue: State<Float> get() = _progressValue

    private val _isLoadingComplete = mutableStateOf(false)
    val isLoadingComplete: State<Boolean> get() = _isLoadingComplete

    fun simulateLoading() {
        viewModelScope.launch {
            while (_progressValue.value < 1f) {
                _progressValue.value += 0.05f
                delay(100)
            }
            _isLoadingComplete.value = true
        }
    }
}