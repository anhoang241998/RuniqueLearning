package com.annguyenhoang.auth.data

import com.annguyenhoang.auth.domain.AuthRepository
import com.annguyenhoang.core.data.networking.post
import com.annguyenhoang.core.domain.AuthInfo
import com.annguyenhoang.core.domain.SessionStorage
import com.annguyenhoang.core.domain.util.DataError
import com.annguyenhoang.core.domain.util.EmptyResult
import com.annguyenhoang.core.domain.util.Result
import com.annguyenhoang.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
) : AuthRepository {
    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(email, password)
        )
        if (result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()
    }

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}