package com.annguyenhoang.core.data.networking.di

import com.annguyenhoang.core.data.networking.HttpClientFactory
import com.annguyenhoang.core.data.networking.auth.EncryptedSessionStorage
import com.annguyenhoang.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}