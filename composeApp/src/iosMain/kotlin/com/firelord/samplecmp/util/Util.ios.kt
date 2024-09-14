package com.firelord.samplecmp.util

import org.koin.dsl.module
import io.github.firelord.sharedpreference.SharedPreference

actual val sharedPreference = module {
    single { SharedPreference("") }
}