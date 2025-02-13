package com.example.mobileinay.api.services

import com.example.mobileinay.api.model.LoginResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileSantriServices {
    @GET("profile")

    fun getProfil(
        @Query("id_santri") id_santri: String,
        @Query("password") password: String,
    ):Call<LoginResponse>
}