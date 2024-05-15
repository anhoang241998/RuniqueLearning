package com.annguyenhoang.auth.data.di

import com.annguyenhoang.auth.data.AuthRepositoryImpl
import com.annguyenhoang.auth.data.EmailPatternValidator
import com.annguyenhoang.auth.domain.AuthRepository
import com.annguyenhoang.auth.domain.PatternValidator
import com.annguyenhoang.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator()
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}