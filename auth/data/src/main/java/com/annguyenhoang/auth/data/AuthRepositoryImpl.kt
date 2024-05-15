package com.annguyenhoang.auth.data

import com.annguyenhoang.auth.domain.AuthRepository
import com.annguyenhoang.core.data.networking.post
import com.annguyenhoang.core.domain.util.DataError
import com.annguyenhoang.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient
) : AuthRepository {
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