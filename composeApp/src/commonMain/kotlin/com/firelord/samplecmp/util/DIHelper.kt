package com.firelord.samplecmp.util

import com.firelord.samplecmp.di.appModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin { modules(appModule()) }
}