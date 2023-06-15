package com.fftools.partten.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fftools.partten.models.GunData
import com.fftools.partten.repositories.retrofit.RetrofitRepositoryImpl
import com.fftools.partten.untilities.Coroutines

class TestRetrofitModel(
    private val repository: RetrofitRepositoryImpl
) : ViewModel() {
    private val testDataState = MutableLiveData<TestDataState>()

    val testUIDataSate: LiveData<TestDataState> get() = testDataState

    fun getData() {
        Coroutines.io {
            runCatching {
                emitTestDataState(isLoading = true)
                repository.getGunData()
            }.onSuccess { result ->
                emitTestDataState(result = result)
            }.onFailure { error ->
                emitTestDataState(error = error.message.toString())
            }
        }
    }

    private fun emitTestDataState(
        isLoading: Boolean = false,
        result: List<GunData>? = null,
        error: String? = null
    ) {
        val dataState = TestDataState(isLoading, result, error)
        testDataState.postValue(dataState)
    }

    data class TestDataState(
        val isLoading: Boolean = false,
        val result: List<GunData>? = null,
        val error: String? = null
    )
}