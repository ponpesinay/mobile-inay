package com.example.mobileinay.api.model

data class LoginResponse(
    val message: String,
    val access_token: String?,
    val token_type: String,
    val expires_in: Int,
    val id_user: String?,
    val name: String?,
)

data class LoginRequest(
    val id_santri: String,
    val password: String
)
