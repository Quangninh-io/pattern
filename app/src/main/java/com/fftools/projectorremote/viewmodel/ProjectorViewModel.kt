package com.fftools.projectorremote.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fftools.projectorremote.database.repository.ProjectorRepository
import com.fftools.projectorremote.model.ProjectorBrandEntity
import com.fftools.projectorremote.utils.Coroutines
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProjectorViewModel(private val projectorRepository: ProjectorRepository): ViewModel() {
    private val listBrand = MutableLiveData<ListBrandDataState>()
    val listBrandState: LiveData<ListBrandDataState> get() = listBrand

    fun getAllBrandList() {

//        emitListBrandDataState(isLoading = true)

        viewModelScope.launch(Dispatchers.IO){
            runCatching {
                emitListBrandDataState(isLoading = true)
                projectorRepository.getAllBrandProjector()
            }.onSuccess {result->
                emitListBrandDataState(result = result)
            }.onFailure {

            }
        }

//        viewModelScope.launch {
////        Coroutines.io {
//            runCatching {
//                emitListBrandDataState(isLoading = true)
//                projectorRepository.getAllBrandProjector()
//            }.onSuccess { result ->
//                emitListBrandDataState(result = result)
//            }.onFailure { error ->
//                emitListBrandDataState(error = error.message.toString())
//            }
////        }
//        }
    }


    private fun emitListBrandDataState(
        isLoading: Boolean = false,
        result: List<ProjectorBrandEntity>? = null,
        error: String? = null
    ) {
        val dataState = ListBrandDataState(isLoading, result, error)
        listBrand.postValue(dataState)
    }

    data class ListBrandDataState(
        val isLoading: Boolean = false,
        val result: List<ProjectorBrandEntity>? = null,
        val error: String? = null
    )
}