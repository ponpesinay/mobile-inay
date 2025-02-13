package com.example.mobileinay
import com.example.mobileinay.api.services.ApiService
import com.example.mobileinay.api.services.LoginServices
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://haflah.ponpesinayatullah.com/api/"

    val loginServices: LoginServices by lazy {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LoginServices::class.java)
    }
}