package com.example.mobileinay.api.services

import com.example.mobileinay.api.model.LoginRequest
import com.example.mobileinay.api.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginServices {
    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}