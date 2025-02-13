package com.example.mobileinay.ui

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileinay.R
import com.example.mobileinay.api.adapter.JadwalAdapter
import com.example.mobileinay.api.adapter.SessionManager
import com.example.mobileinay.api.model.Jadwal
import com.example.mobileinay.api.model.JadwalResponse
import com.example.mobileinay.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JadwalNgajiActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var jadwalAdapter: JadwalAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal_ngaji)
        supportActionBar?.hide()

        val imgKembali : ImageButton = findViewById(R.id.img_back)

        imgKembali.setOnClickListener {
            finish()
        }
//        Set Activity (View)

//        Get Token
        sessionManager = SessionManager(this)
        val token = sessionManager.getTokenAccess()
        val idUser = sessionManager.getIdUser()

        if (token != null) {
            selectDayTextView(token, idUser)
        } else {
            Toast.makeText(this, "Token tidak ditemukan! Silakan login.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun selectDayTextView(token: String?, idUser: String?) {
        val dayss = listOf(
            Pair(R.id.tvSenin, R.id.cvSenin) to "1",
            Pair(R.id.tvSelasa, R.id.cvSelasa) to "2",
            Pair(R.id.tvRabu, R.id.cvRabu) to "3",
            Pair(R.id.tvKamis, R.id.cvKamis) to "4",
            Pair(R.id.tvJumat, R.id.cvJumat) to "5",
            Pair(R.id.tvSabtu, R.id.cvSabtu) to "6",
            Pair(R.id.tvMinggu, R.id.cvMinggu) to "7"
        )

        fetchJadwal(token, idUser, "1")
        dayss.forEach { (views, dayCode) ->
            val (textViewId, cardViewId) = views
            findViewById<TextView>(textViewId).setOnClickListener {
                fetchJadwal(token, idUser, dayCode)
                resetDayBtnStyle()
                highlightSelectedDay(textViewId, cardViewId)
            }
        }

    }

    private fun resetDayBtnStyle() {
        val dayss = listOf(
            Pair(R.id.tvSenin, R.id.cvSenin),
            Pair(R.id.tvSelasa, R.id.cvSelasa),
            Pair(R.id.tvRabu, R.id.cvRabu),
            Pair(R.id.tvKamis, R.id.cvKamis),
            Pair(R.id.tvJumat, R.id.cvJumat),
            Pair(R.id.tvSabtu, R.id.cvSabtu),
            Pair(R.id.tvMinggu, R.id.cvMinggu)
        )

        dayss.forEach { (textViewId, cardViewId) ->
            findViewById<CardView>(cardViewId).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")))
            findViewById<TextView>(textViewId).setTextColor(ColorStateList.valueOf(Color.parseColor("#000000")))
        }
    }

    private fun highlightSelectedDay(textViewId: Int, cardViewId: Int) {
        findViewById<CardView>(cardViewId).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#48CAE4")))
        findViewById<TextView>(textViewId).setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")))
    }

    private fun fetchJadwal(token: String?, idUser: String?, day: String?) {
        RetrofitClient.instance.getJadwal("Bearer $token", idUser, day)
            .enqueue(object :  Callback<JadwalResponse> {
                override fun onResponse(call: Call<JadwalResponse>, response: Response<JadwalResponse>) {
                    if (response.isSuccessful) {
                        val jadwalJson = response.body()?.data
                        jadwalJson?.kelas?.jadwal?.let { showOnView(it) }
                    } else {
                        Log.e("API_ERROR", "Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<JadwalResponse>, t: Throwable) {
                    Log.e("API_FAILURE", "Failure: ${t.message}")
                }
            })
    }

    private fun showOnView(jadwal: List<Jadwal>) {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_card)
        jadwalAdapter = JadwalAdapter(jadwal)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = jadwalAdapter
    }
}
