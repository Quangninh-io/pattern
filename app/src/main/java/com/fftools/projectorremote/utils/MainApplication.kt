package com.fftools.projectorremote.utils

import android.app.Application
import com.fftools.projectorremote.database.ProjectorDatabase
import com.fftools.projectorremote.di.repositoryModule
import com.fftools.projectorremote.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication: Application() {
    private val database by lazy { ProjectorDatabase.getInstance(this) }
    //  Set cho Koin
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(repositoryModule, viewModelModule, appModule))
        }
    }
    private val appModule = module{
        single { database.getProjectorDao() }
    }
}