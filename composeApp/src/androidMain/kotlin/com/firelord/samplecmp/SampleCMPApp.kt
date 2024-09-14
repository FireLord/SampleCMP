package com.firelord.samplecmp

import android.app.Application
import com.firelord.samplecmp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SampleCMPApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SampleCMPApp)
            modules(appModule())
        }
    }
}