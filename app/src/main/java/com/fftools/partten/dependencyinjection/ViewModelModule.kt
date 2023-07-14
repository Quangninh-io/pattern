package com.fftools.partten.dependencyinjection

import com.fftools.partten.viewmodels.TestRetrofitModel
import com.fftools.partten.viewmodels.TestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { TestViewModel(testRepository = get()) }
    viewModel {TestRetrofitModel(get())}
}