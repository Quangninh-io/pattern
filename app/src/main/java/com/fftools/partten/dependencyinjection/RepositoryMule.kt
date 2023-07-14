package com.fftools.partten.dependencyinjection


import com.fftools.partten.repositories.retrofit.RetrofitClient
import com.fftools.partten.repositories.retrofit.RetrofitService
import com.fftools.partten.repositories.TestRepository
import com.fftools.partten.repositories.TestRepositoryImpl
import com.fftools.partten.repositories.retrofit.RetrofitRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val repositoryModule = module {
    factory<TestRepository> { TestRepositoryImpl(androidContext()) }

    single { RetrofitClient.create(RetrofitService::class.java) }
    single { RetrofitRepositoryImpl(get()) }
}


