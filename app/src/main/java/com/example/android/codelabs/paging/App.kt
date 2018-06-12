package com.example.android.codelabs.paging

import android.app.Application
import com.example.android.codelabs.paging.di.appModule
import org.koin.android.ext.android.startKoin

class App : Application(){
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, listOf(appModule))
    }
}