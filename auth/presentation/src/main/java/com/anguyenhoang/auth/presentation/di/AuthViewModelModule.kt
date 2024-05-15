package com.anguyenhoang.auth.presentation.di

import com.anguyenhoang.auth.presentation.login.LoginViewModel
import com.anguyenhoang.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}