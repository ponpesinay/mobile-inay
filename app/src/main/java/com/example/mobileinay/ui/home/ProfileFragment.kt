package com.example.mobileinay.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mobileinay.R
import com.example.mobileinay.api.adapter.SessionManager
import com.example.mobileinay.api.model.JadwalResponse
import com.example.mobileinay.api.model.ProfileResponse
import com.example.mobileinay.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment() {
    private lateinit var namaUser: TextView
    private lateinit var kelasUser: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        // Logout Button
        val btnLogout = view.findViewById<Button>(R.id.btn_logOut)
        btnLogout.setOnClickListener {
            // Tambahkan logika logout API jika perlu
            requireActivity().finish()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        namaUser = view.findViewById(R.id.Tv_NameUser)
        kelasUser = view.findViewById(R.id.Tv_kelas)
        val sharesPrefs = SessionManager(requireContext())
        fetchProfile(sharesPrefs.getTokenAccess(), sharesPrefs.getIdUser())

    }

    private fun fetchProfile(token: String?, idUser: String?) {
        RetrofitClient.instance.getProfiles("Bearer $token", idUser).
            enqueue(object : Callback<ProfileResponse> {
                override fun onResponse(
                    call: Call<ProfileResponse>,
                    response: Response<ProfileResponse>
                ) {
                    if (response.isSuccessful) {
                        val jadwalJson = response.body()?.data
                        namaUser.text = jadwalJson?.nama
                        kelasUser.text = jadwalJson?.kelas?.kelas
                    } else {
                        Log.e("API_ERROR", "Error: ${response.code()}")
                    }
                }

            override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                Log.e("API_FAILURE", "Failure: ${t.message}")
            }
        })
    }
}
