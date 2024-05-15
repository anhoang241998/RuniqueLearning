package com.annguyenhoang.auth.domain

import com.annguyenhoang.core.domain.util.DataError
import com.annguyenhoang.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}