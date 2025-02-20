package com.example.mobileinay.ui


//import com.example.mobileinay.retrofit.ApiClient
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileinay.R
import com.example.mobileinay.UserNilai
import com.example.mobileinay.api.adapter.KehadiranAdapter
import com.example.mobileinay.api.adapter.NilaiAdapter
import com.example.mobileinay.api.adapter.SessionManager
import com.example.mobileinay.api.model.KehadiranData
import com.example.mobileinay.api.model.KehadiranResponse
import com.example.mobileinay.api.model.NilaiData
import com.example.mobileinay.api.model.NilaiResponse
import com.example.mobileinay.nilai
import com.example.mobileinay.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NilaiActivity : AppCompatActivity() {
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var adapter: UserNilai
    private lateinit var spinnerSemester: Spinner
//    private lateinit var spinnerNilai: Spinner
    private lateinit var sessionManager: SessionManager
    private lateinit var nilaiAdapter: NilaiAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai)
        supportActionBar?.hide()

        val btnBack: ImageButton = findViewById(R.id.img_kembali)

        btnBack.setOnClickListener {
            finish()
        }

        sessionManager = SessionManager(this)
        spinnerSemester = findViewById(R.id.SpinnerSemester)
        val token = sessionManager.getTokenAccess()
        val idUser = sessionManager.getIdUser()
        var semester = "ganjil"

        val semesterOptions = arrayOf("Semester 1", "Semester 2")
        val semesterAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, semesterOptions)
        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSemester.adapter = semesterAdapter
        spinnerSemester.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.e("Position", "$position")
                if (position == 0) {
                    semester = "ganjil"
                } else {
                    semester = "genap"
                }
                fetchNilai(token, idUser, semester)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        if (token != null) {
            fetchNilai(token, idUser, semester)
        } else {
            Toast.makeText(this, "Token tidak ditemukan! Silakan login.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchNilai(token: String?, idUser: String?, semester: String?) {
        RetrofitClient.instance.getNilai("Bearer $token", idUser, semester).
        enqueue(object : Callback<NilaiResponse> {
            override fun onResponse(
                call: Call<NilaiResponse>,
                response: Response<NilaiResponse>
            ) {
                if (response.isSuccessful) {
                    val jadwalJson = response.body()?.data
                    jadwalJson?.let { showOnView(it) }
                } else {
                    Log.e("API_ERROR", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<NilaiResponse>, t: Throwable) {
                Log.e("API_FAILURE", "Failure: ${t.message}")
            }
        })
    }


    private fun showOnView(nilai: List<NilaiData>?) {
        val recyclerView = findViewById<RecyclerView>(R.id.rvNilai)
        nilaiAdapter = NilaiAdapter(nilai)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = nilaiAdapter
    }
}
