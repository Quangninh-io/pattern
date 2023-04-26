package com.fftools.partten.untilities

import android.app.Application
import com.fftools.partten.dependencyinjection.repositoryModule
import com.fftools.partten.dependencyinjection.viewModelModule

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationConfig : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationConfig)
            modules(listOf(repositoryModule, viewModelModule))
        }
    }
}