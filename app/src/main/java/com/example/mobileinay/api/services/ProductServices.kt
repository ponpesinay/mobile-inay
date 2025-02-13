package com.example.mobileinay.api.services
import com.example.mobileinay.api.model.Product
import retrofit2.Call
import retrofit2.http.GET


interface ProductServices {
    @GET("products{/id}")
    fun getAll(): Call<Product>
}