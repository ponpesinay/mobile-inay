package com.example.mobileinay

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileinay.api.adapter.KehadiranAdapter
import com.example.mobileinay.api.adapter.SessionManager
import com.example.mobileinay.api.model.KehadiranData
import com.example.mobileinay.api.model.KehadiranResponse
import com.example.mobileinay.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KeamananActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var kehadiranAdapter: KehadiranAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keamanan)
        supportActionBar?.hide()

        val btnBack: ImageButton = findViewById(R.id.img_kembali)

        btnBack.setOnClickListener {
            finish()
        }

        sessionManager = SessionManager(this)
        val token = sessionManager.getTokenAccess()
        val idUser = sessionManager.getIdUser()

        if (token != null) {
            fetchKehadiran(token, idUser)
//            Log.e("Test", "$idUser")
        } else {
            Toast.makeText(this, "Token tidak ditemukan! Silakan login.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchKehadiran(token: String?, idUser: String?) {
        RetrofitClient.instance.getKehadiran("Bearer $token", idUser).
        enqueue(object : Callback<KehadiranResponse> {
            override fun onResponse(
                call: Call<KehadiranResponse>,
                response: Response<KehadiranResponse>
            ) {
                if (response.isSuccessful) {
                    val jadwalJson = response.body()?.data
                    jadwalJson?.let { showOnView(it) }
                } else {
                    Log.e("API_ERROR", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<KehadiranResponse>, t: Throwable) {
                Log.e("API_FAILURE", "Failure: ${t.message}")
            }
        })
    }


    private fun showOnView(kehadiran: List<KehadiranData>?) {
        val recyclerView = findViewById<RecyclerView>(R.id.rvKehadiran)
        kehadiranAdapter = KehadiranAdapter(kehadiran)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = kehadiranAdapter
    }
}