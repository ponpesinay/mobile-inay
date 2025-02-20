package com.example.mobileinay.api.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileinay.R
import com.example.mobileinay.api.model.MapelDaUm
import com.example.mobileinay.api.model.MapelWithPengajar

class MapelAdapter (
  private var mapelList: List<MapelWithPengajar>?
) : RecyclerView.Adapter<MapelAdapter.MapelViewHolder>(){

  class MapelViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    private  val namaMapel: TextView? = itemView.findViewById(R.id.namaMapel)
    private val namaPengajar: TextView? = itemView.findViewById(R.id.namaPengajar)

    fun bind(mapel: MapelWithPengajar?){
      namaMapel?.text = mapel?.mapel
      namaPengajar?.text = mapel?.pengajar
    }

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapelViewHolder {
    val itemView = LayoutInflater.from(parent.context)
      .inflate(R.layout.card_mapel, parent, false)
    return MapelViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: MapelViewHolder, position: Int) {
    mapelList?.get(position)?.let { holder.bind(it) }
  }

  override fun getItemCount(): Int = mapelList?.size?: 0

  @SuppressLint("NotifyDataSetChanged")
  fun updateData(newList: List<MapelWithPengajar>?) {
    mapelList = newList ?: emptyList() // Jika null, set list kosong
    notifyDataSetChanged()
  }
}