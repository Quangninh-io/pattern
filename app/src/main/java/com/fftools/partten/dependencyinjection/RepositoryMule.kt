package com.fftools.partten.dependencyinjection


import com.fftools.partten.repositories.TestRepository
import com.fftools.partten.repositories.TestRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory<TestRepository> { TestRepositoryImpl(androidContext()) }
}