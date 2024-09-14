package com.firelord.samplecmp.di

import com.firelord.samplecmp.home.HomeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val viewModelModule = module {
    singleOf(::HomeViewModel)
}