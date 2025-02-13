//package com.example.mobileinay
//
//import retrofit2.Call
//import retrofit2.http.GET
//import retrofit2.http.Path
//
////data class LoginResponse(val message: String, val user: User?)
//
//data class User(
//    val nama: String,
////    val kelas: String
//)
//
//interface ApiService {
//    // Login API Endpoint
//    @GET("santri/{id}")
//    fun getUserProfile(@Path("id") id: String): Call<User>
//
////    @GET("santri/{id}")
////    fun loginUser(@Path("id") id_santri: String): Call<LoginResponse>
//
//    @GET("api/santri")
//    fun get(): Call<List<SantriResponse>>
//    @GET("api/kelas")
//    fun get_kelas(): Call<List<kelas_santri>>
//    @GET("api/jadwal")
//    fun get_jadwal(): Call<List<jadwal_santri>>
//    @GET("api/nilai")
//    fun get_nilai(): Call<List<nilai_santri>>
//    @GET("api/pengajar")
//    fun get_pengajar(): Call<List<pengajar>>
//    @GET("api/keamanan")
//    fun get_keamanan(): Call<List<keamanan_santri>>
//    abstract fun LoginServices(idSantri: String, password: String): Any
//}