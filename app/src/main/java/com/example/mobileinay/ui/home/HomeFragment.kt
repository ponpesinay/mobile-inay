package com.example.mobileinay.ui.home


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileinay.KeamananActivity
import com.example.mobileinay.MajmuActivity
import com.example.mobileinay.NilaiActivity
import com.example.mobileinay.R
import com.example.mobileinay.RaportActivity
import com.example.mobileinay.api.adapter.JadwalAdapter
import com.example.mobileinay.api.adapter.SessionManager
import com.example.mobileinay.api.model.Jadwal
import com.example.mobileinay.api.model.JadwalResponse
import com.example.mobileinay.retrofit.RetrofitClient
import com.example.mobileinay.ui.JadwalNgajiActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var jadwalAdapter: JadwalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val sharesPrefs = SessionManager(requireContext())
//      Set Name User
        view.findViewById<TextView>(R.id.NamaUser).text = sharesPrefs.getNameUser()

        val imgNilai = view?.findViewById<ImageButton>(R.id.imgNilai)
        val imgNgaji = view?.findViewById<ImageButton>(R.id.imgJadwal_ngaji)
        val imgAman = view?.findViewById<ImageButton>(R.id.imgkeamanan)
        val imgLaporan = view?.findViewById<ImageButton>(R.id.imgraport)
        val imgBuku = view?.findViewById<ImageButton>(R.id.majmu)

        imgNilai?.setOnClickListener {
            val intent = Intent(activity, NilaiActivity::class.java)
            startActivity(intent)
        }
        imgNgaji?.setOnClickListener{

            val intent = Intent(activity, JadwalNgajiActivity::class.java)
            startActivity(intent)
        }
        imgAman?.setOnClickListener{
            val intent = Intent(activity, KeamananActivity::class.java)
            startActivity(intent)
        }
        imgLaporan?.setOnClickListener {
            val intent = Intent(activity, RaportActivity::class.java)
            startActivity(intent)
        }
        imgBuku?.setOnClickListener {
            val intent = Intent(activity, MajmuActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inisialisasi RecyclerView
        recyclerView = view.findViewById(R.id.recycleJadwal)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Panggil API untuk fetch data
        val sharedPrefs = SessionManager(requireContext())
        fetchTodayJadwal(sharedPrefs.getTokenAccess(), sharedPrefs.getIdUser())
    }

    private fun fetchTodayJadwal(token: String?, idUser: String?) {
        RetrofitClient.instance.getJadwal("Bearer $token", idUser, "").
            enqueue(object : Callback<JadwalResponse> {
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

    private fun showOnView(jadwalList: List<Jadwal>) {
        jadwalAdapter = JadwalAdapter(jadwalList)
        recyclerView.adapter = jadwalAdapter
    }
}