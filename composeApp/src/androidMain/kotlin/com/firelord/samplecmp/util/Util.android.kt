package com.firelord.samplecmp.util

import org.koin.dsl.module
import io.github.firelord.sharedpreference.SharedPreference
import org.koin.android.ext.koin.androidApplication

actual val sharedPreference = module  {
    single {
        val context = androidApplication().applicationContext
        SharedPreference(context)
    }
}