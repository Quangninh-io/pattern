package com.fftools.projectorremote.di

import com.fftools.projectorremote.viewmodel.MainViewModel
import com.fftools.projectorremote.viewmodel.ProjectorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(mainRepository = get() ) }
    viewModel { ProjectorViewModel(projectorRepository = get() )}
}