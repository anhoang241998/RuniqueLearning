package com.anguyenhoang.auth.presentation.login

import com.annguyenhoang.core.presentation.ui.UiText

sealed interface LoginEvent {
    data class Error(val error: UiText) : LoginEvent
    data object LoginSuccess : LoginEvent
}