package com.fftools.partten.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fftools.partten.repositories.TestRepository
import com.fftools.partten.untilities.Coroutines

class TestViewModel(
    private val testRepository: TestRepository
) : ViewModel() {
    private val testDataState = MutableLiveData<TestDataState>()
    val testUIDataSate: LiveData<TestDataState> get() = testDataState

    fun getData(name: String) {
        Coroutines.io {
            runCatching {
                emitTestDataState(isLoading = true)
                testRepository.test(name)
            }.onSuccess { result ->
                emitTestDataState(result = result)
            }.onFailure { error ->
                emitTestDataState(error = error.message.toString())
            }
        }
    }

    private fun emitTestDataState(
        isLoading: Boolean = false,
        result: Int? = null,
        error: String? = null
    ) {
        val dataState = TestDataState(isLoading, result, error)
        testDataState.postValue(dataState)
    }

    data class TestDataState(
        val isLoading: Boolean = false,
        val result: Int? = null,
        val error: String? = null
    )
}