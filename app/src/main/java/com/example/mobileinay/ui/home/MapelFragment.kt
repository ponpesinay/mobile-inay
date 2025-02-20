package com.example.mobileinay.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileinay.R
import com.example.mobileinay.api.adapter.MapelAdapter
import com.example.mobileinay.api.adapter.SessionManager
import com.example.mobileinay.api.model.MapelResponse
import com.example.mobileinay.api.model.MapelWithPengajar
import com.example.mobileinay.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapelFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var mapelAdapter: MapelAdapter

    override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mapel, container, false)
        val sharesprefs = SessionManager(requireContext())

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycleMapel)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val sharesPrefs = SessionManager(requireContext())
        fetchAllMapel(sharesPrefs.getTokenAccess(), sharesPrefs.getIdUser())
    }

    private fun fetchAllMapel(token: String?, idUser: String?) {
        RetrofitClient.instance.getMapels("Bearer $token", idUser).
            enqueue(object : Callback<MapelResponse> {
                override fun onResponse(
                    call: Call<MapelResponse>,
                    response: Response<MapelResponse>
                ) {
                    if (response.isSuccessful) {
                        val mapelJson = response.body()?.data
                        mapelJson?.let { showOnView(it) }
                        Log.e("Mapel", "$mapelJson")
                    } else {
                        Log.e("API_ERROR", "Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<MapelResponse>, t: Throwable) {
                    Log.e("API_FAILURE", "Failure: ${t.message}")
                }
            })
    }

    private fun showOnView(mapelList: List<MapelWithPengajar>){
        mapelAdapter = MapelAdapter(mapelList)
        recyclerView.adapter = mapelAdapter
    }
}