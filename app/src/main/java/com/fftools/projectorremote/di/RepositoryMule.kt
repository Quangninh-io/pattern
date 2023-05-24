package com.fftools.projectorremote.di

import com.fftools.projectorremote.database.repository.ProjectorRepository
import com.fftools.projectorremote.repositories.MainRepository
import com.fftools.projectorremote.repositories.MainRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val repositoryModule = module {
    factory<MainRepository> { MainRepositoryImpl(androidContext()) }
    single { ProjectorRepository(get()) }
}