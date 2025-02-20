package com.example.mobileinay.api.services

import com.example.mobileinay.api.model.JadwalResponse
import com.example.mobileinay.api.model.KehadiranResponse
import com.example.mobileinay.api.model.LoginRequest
import com.example.mobileinay.api.model.LoginResponse
import com.example.mobileinay.api.model.MapelResponse
import com.example.mobileinay.api.model.NilaiResponse
import com.example.mobileinay.api.model.ProfileResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("login")
    fun loginUser(@Body request: LoginRequest): Call<LoginResponse>

    @GET("jadwals")
    fun getJadwal(
        @Header("Authorization") token: String,
        @Query("id_user") idUser:  String?,
        @Query("day") day: String?
    ):Call<JadwalResponse>

    @GET("profiles")
    fun getProfiles(
        @Header("Authorization") token: String,
        @Query("id_user") idUser:  String?,
    ):Call<ProfileResponse>

    @GET("mapel")
    fun getMapels(
        @Header("Authorization") token: String?,
        @Query("id_user") idUser:  String?,
    ): Call<MapelResponse>

    @GET("presensis")
    fun getKehadiran(
        @Header("Authorization") token: String?,
        @Query("id_user") idUser:  String?,
    ): Call<KehadiranResponse>

    @GET("nilais")
    fun getNilai(
        @Header("Authorization") token: String?,
        @Query("id_user") idUser:  String?,
        @Query("semester") semester:  String?,
    ): Call<NilaiResponse>
}