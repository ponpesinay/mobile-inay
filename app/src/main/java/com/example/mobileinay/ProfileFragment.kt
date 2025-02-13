package com.example.mobileinay

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobileinay.api.adapter.SessionManager
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


        namaUser = view.findViewById(R.id.Tv_NameUser)
        kelasUser = view.findViewById(R.id.Tv_kelas)

        val sharesPrefs = SessionManager(requireContext())
        val accessToken = sharesPrefs.getTokenAccess()

//        if (!accessToken.isNullOrEmpty() ){
//            getUserProfil(accessToken)
//        }else{
//            Log.d("HomeFragment", "Token yang dikirim: Bearer $accessToken")
//            Toast.makeText(requireContext(), "Token tidak ditemukan", Toast.LENGTH_SHORT).show()
//        }

        // Logout Button
        val btnLogout = view.findViewById<Button>(R.id.btn_logOut)
        btnLogout.setOnClickListener {
            // Tambahkan logika logout API jika perlu
            requireActivity().finish()
        }

        return view
    }

//    private fun getUserProfil(accssToken: String) {
//        val authHeader = "Bearer $accssToken"
//        val idUser = "25021000"
//
//        ApiClient.loginServices.getProfile(authHeader, idUser)
//            .enqueue(object : Callback<Profile> {
//                override fun onResponse(
//                    call: Call<Profile>,
//                    response: Response<Profile>
//                ) {
//                    Log.d("HomeFragment", "Response Code: ${response.code()}") // Log response code
//                    Log.d("HomeFragment", "Response Body: ${response.body()}") // Log response body
//                    if (response.isSuccessful){
//                        val userProtected = response.body()
//                        if (userProtected?.data != null) {
//                            namaUser.text = "${userProtected.data.nama}"
//                            kelasUser.text = "${userProtected.data.kelas?.kelas}"
//                        } else {
//                            namaUser.text = "Data user tidak ditemukan"
//                            kelasUser.text= "DATA kelas tidak ditemukan"
//                            Log.e("HomeFragment", "Data user kosong: ${response.body()}")
//                        }
//                    }else{
//                        namaUser.text = "Gagal memuat nama user"
//                        Log.e("HomeFragment", "Error Response: ${response.errorBody()?.string()}")
//                    }
//                }
//
//                override fun onFailure(call: Call<Profile>, t: Throwable) {
//                    Log.e("HomeFragment", "Request gagal: ${t.message}", t)
//                    namaUser.text = "Hubungan bermasalah"
//                }
//
//            })
//
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        getProfile(view)
    }

//    private fun getProfile(view: View){
//
//        val call = ApiClient.profileSantriServices.getProfile()
//
//        call.enqueue(object : Callback<ProfileSantri>{
//            override fun onResponse(call: Call<ProfileSantri>, response: Response<ProfileSantri>) {
//                val data = response.body();
//                if (response.isSuccessful) {
//                        view.findViewById<TextView>(R.id.Tv_NameUser)?.text = data?.santri_nama
//                        view.findViewById<TextView>(R.id.Tv_kelas)?.text = data?.santri_kelas
//
//                } else {
//                    Log.e("ProfileFragment", "Response failed: ${response.errorBody()?.string()}")
//                }
//            }
//
//            override fun onFailure(call: Call<ProfileSantri>, t: Throwable) {
//                Log.e("ProfileFragment", "Error fetching user data", t)
//            }
//
//        })
//    }
}
