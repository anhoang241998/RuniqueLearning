package com.annguyenhoang.core.data.networking.di

import com.annguyenhoang.core.data.networking.HttpClientFactory
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
}