package com.firelord.samplecmp.di

import com.firelord.samplecmp.util.sharedPreference

fun appModule() = listOf(
    sharedPreference,
    viewModelModule
)